package com.example.issuemanagmentproject.api;

import com.example.issuemanagmentproject.dto.IssueDto;
import com.example.issuemanagmentproject.entity.Issue;
import com.example.issuemanagmentproject.entity.IssueStatus;
import com.example.issuemanagmentproject.repository.IssueRepository;
import com.example.issuemanagmentproject.response.DeleteIssueResponse;
import com.example.issuemanagmentproject.response.DeleteProjectResponse;
import com.example.issuemanagmentproject.service.IssueService;
import com.example.issuemanagmentproject.service.impl.IssueServiceImpl;
import com.example.issuemanagmentproject.util.ApiPaths;
import com.example.issuemanagmentproject.util.TPage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping(ApiPaths.IssuePath.CTRL)
@Api(value = ApiPaths.IssuePath.CTRL, description = "Issue APIs")
public class IssueController
{

    @Autowired
    private IssueServiceImpl issueServiceImpl;


    @Autowired
    private IssueRepository issueRepository;


    @GetMapping("/getAll")
    public List<Issue> getAll()
    {
        return  issueRepository.findAll();
    }


    @GetMapping("/pagination")
    public ResponseEntity<TPage<IssueDto>> getAllByPagination(Pageable pageable) {
        TPage<IssueDto> data = issueServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id", required = true) Long id) {
        IssueDto issue = issueServiceImpl.getById(id);
        return ResponseEntity.ok(issue);
    }


    @PostMapping
    public ResponseEntity<IssueDto> createIssue(@Valid @RequestBody IssueDto issue)
    {
        return ResponseEntity.ok(issueServiceImpl.save(issue));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteIssueResponse> deleteById(@PathVariable(value = "id", required = true) Long id) {
        issueServiceImpl.delete(id);
        return ResponseEntity.ok(new DeleteIssueResponse(true));
    }



}
