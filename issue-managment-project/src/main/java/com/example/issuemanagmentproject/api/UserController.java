package com.example.issuemanagmentproject.api;

import com.example.issuemanagmentproject.dto.ProjectDto;
import com.example.issuemanagmentproject.dto.UserDto;
import com.example.issuemanagmentproject.entity.Project;
import com.example.issuemanagmentproject.service.UserService;
import com.example.issuemanagmentproject.service.impl.ProjectServiceImpl;
import com.example.issuemanagmentproject.service.impl.UserServiceImpl;
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
@RequestMapping(ApiPaths.UserPath.CTRL)
@Api(value = ApiPaths.UserPath.CTRL, description = "User APIs")
public class UserController
{

    @Autowired
    private UserServiceImpl userServiceImpl;




    //Test
    @GetMapping("/sayHello")
    public String getHello()
    {
        return "Say Hello";
    }

                                            /* ************** http metods *************** */

    @GetMapping("/pagination")
    @ApiOperation(value = "Get By Pagination Operation", response = UserDto.class)
    public ResponseEntity<TPage<UserDto>> getAllByPagination(Pageable pageable) {
        TPage<UserDto> data = userServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }

    @GetMapping()
    @ApiOperation(value = "Get All By Operation", response = UserDto.class)
    public ResponseEntity<List<UserDto>> getAll() {
        List<UserDto> data = userServiceImpl.getAll();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation", response = UserDto.class)
    public ResponseEntity<UserDto> getById(@PathVariable(value = "id", required = true) Long id) {
        UserDto user = userServiceImpl.getById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    @ApiOperation(value = "Create Operation", response = UserDto.class)
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {
        return ResponseEntity.ok(userServiceImpl.save(user));
    }

}
