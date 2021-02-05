package com.example.issuemanagmentproject.service;


import com.example.issuemanagmentproject.dto.ProjectDto;
import com.example.issuemanagmentproject.entity.Project;
import com.example.issuemanagmentproject.response.DeleteProjectResponse;
import com.example.issuemanagmentproject.util.TPage;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService
{
    ProjectDto save (ProjectDto project);

    ProjectDto getById (Long id);

    Project  getProjectCode (String projectCode);

    List<Project> getByProjectCodeContains (String projectCode);

    TPage<ProjectDto> getAllPageable(Pageable pageable);

    DeleteProjectResponse delete (Long id);

    ProjectDto update(Long id, ProjectDto project);

    List<Project> getAllProject();
}
