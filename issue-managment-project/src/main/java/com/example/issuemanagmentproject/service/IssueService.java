package com.example.issuemanagmentproject.service;

import com.example.issuemanagmentproject.dto.IssueDto;
import com.example.issuemanagmentproject.response.DeleteIssueResponse;
import com.example.issuemanagmentproject.util.TPage;
import org.springframework.data.domain.Pageable;

public interface IssueService
{
    IssueDto save (IssueDto issue);

    IssueDto getById (Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    DeleteIssueResponse delete (Long id);
}
