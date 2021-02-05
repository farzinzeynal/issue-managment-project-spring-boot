package com.example.issuemanagmentproject.dto;

import com.example.issuemanagmentproject.entity.IssueStatus;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Issue DTO")
public class IssueDto
{

    @ApiModelProperty(required = true,value = "ID")
    private Long id;

    @ApiModelProperty(required = true,value = "Description")
    private String description;

    @ApiModelProperty(required = true,value = "Issue Details")
    private String details;

    @ApiModelProperty(required = true,value = "Date")
    private Date date;

    @ApiModelProperty(required = true,value = "Issue Status")
    private IssueStatus issueStatus;


    @ApiModelProperty(required = true,value = "Assignee")
    private UserDto assignee;

    @ApiModelProperty(required = true,value = "Project")
    private ProjectDto project;


    @NotNull
    private  Long manag_id;
    @NotNull
    private  Long proj_id;

}




