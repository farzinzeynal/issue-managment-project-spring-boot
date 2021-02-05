package com.example.issuemanagmentproject.service.impl;


import com.example.issuemanagmentproject.entity.IssueHistory;
import com.example.issuemanagmentproject.repository.IssueHistoryRepository;
import com.example.issuemanagmentproject.service.IssueHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IssueHistoryServiceImpl implements IssueHistoryService
{

    @Autowired
    private IssueHistoryRepository issueHistoryRepository;

    @Override
    public IssueHistory save(IssueHistory issueHistory)
    {
        if (issueHistory.getCreatedAt()==null){throw  new IllegalArgumentException("Issue date cannot be null");}

        return issueHistoryRepository.save(issueHistory) ;
    }

    @Override
    public IssueHistory getById(Long id) {
        return issueHistoryRepository.getOne(id);
    }

    @Override
    public Page<IssueHistory> getAllPageable(Pageable pageable) {
        return issueHistoryRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(IssueHistory issueHistory) {
        issueHistoryRepository.delete(issueHistory);
        return Boolean.TRUE;
    }
}
