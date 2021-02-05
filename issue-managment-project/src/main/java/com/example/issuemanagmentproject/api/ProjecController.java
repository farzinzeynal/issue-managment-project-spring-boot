package com.example.issuemanagmentproject.api;

import com.example.issuemanagmentproject.dto.ProjectDto;
import com.example.issuemanagmentproject.entity.Project;
import com.example.issuemanagmentproject.response.DeleteProjectResponse;
import com.example.issuemanagmentproject.service.impl.ProjectServiceImpl;
import com.example.issuemanagmentproject.util.ApiPaths;
import com.example.issuemanagmentproject.util.TPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiPaths.ProjectPath.CTRL)
@Api(value = ApiPaths.ProjectPath.CTRL, description = "Project APIs")

public class ProjecController
{
    @Autowired
    private ProjectServiceImpl projectServiceimpl;

    //Test
    @GetMapping("/sayHello")
    public String getHello()
    {
        return "Say Hello";
    }

                                      /* ************** http metods *************** */

    @GetMapping("/getAll")
    @ApiOperation(value = "Get All JSON Array", response = ProjectDto.class)
    public List<Project> getAllProject()
    {
      return (List<Project>)  projectServiceimpl.getAllProject();
    }


    @GetMapping("/pagination")
    @ApiOperation(value = "Get By Pagination Operation", response = ProjectDto.class)
    public ResponseEntity<TPage<ProjectDto>> getAllByPagination(Pageable pageable) {
        TPage<ProjectDto> data = projectServiceimpl.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getById( @PathVariable("id") Long id)
    {
        ProjectDto projectDto = projectServiceimpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping
    @ApiOperation(value = "Create Operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto projectDto)
    {
        return ResponseEntity.ok(projectServiceimpl.save(projectDto));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> updateProject(@PathVariable("id") Long id,
                                                    @Valid @RequestBody ProjectDto projectDto)
    {
        return ResponseEntity.ok(projectServiceimpl.update(id, projectDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation", response = Boolean.class)
    public ResponseEntity<DeleteProjectResponse> delete(@PathVariable(value = "id", required = true) Long id)
    {
        projectServiceimpl.delete(id);
        return ResponseEntity.ok(new DeleteProjectResponse(true));
    }


}
