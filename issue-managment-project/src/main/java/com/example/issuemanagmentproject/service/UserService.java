package com.example.issuemanagmentproject.service;

import com.example.issuemanagmentproject.dto.UserDto;
import com.example.issuemanagmentproject.entity.User;
import com.example.issuemanagmentproject.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService
{
    UserDto save (UserDto user);

    UserDto getById (Long id);

    TPage<UserDto> getAllPageable(Pageable pageable);

    UserDto getByUsername (String userName);


}
