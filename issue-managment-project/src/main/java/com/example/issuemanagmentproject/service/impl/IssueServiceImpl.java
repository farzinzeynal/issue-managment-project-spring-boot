package com.example.issuemanagmentproject.service.impl;


import com.example.issuemanagmentproject.dto.IssueDto;
import com.example.issuemanagmentproject.entity.Issue;
import com.example.issuemanagmentproject.entity.IssueStatus;
import com.example.issuemanagmentproject.repository.IssueRepository;
import com.example.issuemanagmentproject.repository.ProjectRepository;
import com.example.issuemanagmentproject.repository.UserRepository;
import com.example.issuemanagmentproject.response.DeleteIssueResponse;
import com.example.issuemanagmentproject.service.IssueService;
import com.example.issuemanagmentproject.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;

import static com.example.issuemanagmentproject.entity.IssueStatus.OPEN;

@Service
public class IssueServiceImpl implements IssueService
{


    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public IssueDto save(IssueDto issueDto) {

        issueDto.setDate(new Date());

        Issue issueEntity = modelMapper.map(issueDto, Issue.class);

        issueEntity.setProject(projectRepository.getOne(issueDto.getProj_id()));
        issueEntity.setAssignee(userRepository.getOne(issueDto.getManag_id()));

        issueEntity = issueRepository.save(issueEntity);

        issueDto.setId(issueEntity.getId());

        return issueDto;

    }

    @Override
    public IssueDto getById(Long id) {
        Issue issue = issueRepository.getOne(id);
        return modelMapper.map(issue, IssueDto.class);
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {

        Page<Issue> data = issueRepository.findAll(pageable);
        TPage page = new TPage<IssueDto>();
        IssueDto[] dtos = modelMapper.map(data.getContent(),IssueDto[].class);
        page.setStat(data, Arrays.asList(dtos));
        return page;

    }

    @Override
    public DeleteIssueResponse delete(Long id)
    {
        issueRepository.deleteById(id);
        return  new DeleteIssueResponse(true);
    }
}
