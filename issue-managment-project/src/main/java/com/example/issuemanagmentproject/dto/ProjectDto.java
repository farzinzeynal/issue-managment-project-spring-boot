package com.example.issuemanagmentproject.dto;

import com.example.issuemanagmentproject.entity.User;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Project DTO")
public class ProjectDto
{
    @ApiModelProperty(value = "Project ID")
    private Long id;

    @NotNull
    @ApiModelProperty(required = true,value = "Name of Project")
    private String projectName;

    @NotNull
    @ApiModelProperty(required = true,value = "Code of Project")
    private String projectCode;

    @NotNull
    @ApiModelProperty(required = true,value = "Project Manager ID")
    private Long project_manag_id;


    @ApiModelProperty(required = true,value = "Project Manager Name")
    private UserDto manager;

}
