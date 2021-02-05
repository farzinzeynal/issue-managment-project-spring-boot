package com.example.issuemanagmentproject.repository;

import com.example.issuemanagmentproject.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<Issue,Long>
{

}
