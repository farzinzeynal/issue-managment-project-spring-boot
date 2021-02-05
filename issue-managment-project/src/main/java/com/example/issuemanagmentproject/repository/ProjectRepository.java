package com.example.issuemanagmentproject.repository;


import com.example.issuemanagmentproject.dto.ProjectDto;
import com.example.issuemanagmentproject.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long>
{
    //  List<Project> getAllByProjectCode(String projectCode);



    Page<Project> findAll(Pageable pageable);

    List<Project> findAll(Sort sort);

    List<Project> findAll();

    Project getByProjectCodeAndIdNot(String project_code, Long id);

    Project getByProjectCode (String project_code);


}
