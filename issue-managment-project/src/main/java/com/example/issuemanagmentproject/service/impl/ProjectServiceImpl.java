package com.example.issuemanagmentproject.service.impl;

import com.example.issuemanagmentproject.dto.ProjectDto;
import com.example.issuemanagmentproject.entity.Project;
import com.example.issuemanagmentproject.entity.User;
import com.example.issuemanagmentproject.repository.ProjectRepository;
import com.example.issuemanagmentproject.repository.UserRepository;
import com.example.issuemanagmentproject.response.DeleteProjectResponse;
import com.example.issuemanagmentproject.service.ProjectService;
import com.example.issuemanagmentproject.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class ProjectServiceImpl implements ProjectService
{

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

                                  /* *****************   Methods   *****************   */

    @Override
    public ProjectDto save(ProjectDto project) {

        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());
        if(projectCheck!=null)
        {
            throw new IllegalArgumentException("Project Code Already Exist");
        }

        Project p = modelMapper.map(project, Project.class);

        User user = userRepository.getOne(project.getProject_manag_id());
        p.setManager(user);

        p= projectRepository.save(p);
        project.setId(p.getId());
        return project;
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p = projectRepository.getOne(id);
        return modelMapper.map(p,ProjectDto.class);
    }

    @Override
    public Project getProjectCode(String projectCode)
    {

        return null;
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public TPage<ProjectDto> getAllPageable(Pageable pageable) {
        Page<Project> data = projectRepository.findAll(pageable);
        TPage<ProjectDto> respnose = new TPage<ProjectDto>();
        respnose.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDto[].class)));
        return respnose;
    }

    @Override
    public DeleteProjectResponse delete(Long id) {
        projectRepository.deleteById(id);
        DeleteProjectResponse deleteProjectResponse =  new DeleteProjectResponse();
        deleteProjectResponse.setIsDeleted(true);
        return deleteProjectResponse;
    }


    @Override
    public ProjectDto update(Long id, ProjectDto projectDto)
    {
        Project projectDb = projectRepository.getOne(id);
        if (projectDb == null)
            throw new IllegalArgumentException("Project Does Not Exist ID:" + id);

        Project projectCheck = projectRepository.getByProjectCode(projectDto.getProjectCode());
        if (projectCheck != null)
            throw new IllegalArgumentException("Project Code or Name Already Exist");

        projectDb.setProjectCode(projectDto.getProjectCode());
        projectDb.setProjectName(projectDto.getProjectName());

        projectRepository.save(projectDb);
        return modelMapper.map(projectDb, ProjectDto.class);
    }


    @Override
    public List<Project> getAllProject() {
        return  projectRepository.findAll();
    }

}
