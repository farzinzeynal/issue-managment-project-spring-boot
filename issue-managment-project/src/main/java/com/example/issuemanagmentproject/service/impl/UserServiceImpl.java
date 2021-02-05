package com.example.issuemanagmentproject.service.impl;


import com.example.issuemanagmentproject.dto.RegistrationRequest;
import com.example.issuemanagmentproject.dto.UserDto;
import com.example.issuemanagmentproject.entity.User;
import com.example.issuemanagmentproject.repository.UserRepository;
import com.example.issuemanagmentproject.service.UserService;
import com.example.issuemanagmentproject.util.TPage;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService
{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto save(UserDto user) {

        User u = modelMapper.map(user, User.class);
        u = userRepository.save(u);
        user.setId(u.getId());
        return user;
    }

    @Override
    public UserDto getById(Long id) {
        User u = userRepository.getOne(id);
        return modelMapper.map(u, UserDto.class);

    }

    @Override
    public TPage<UserDto> getAllPageable(Pageable pageable) {
        Page<User> data = userRepository.findAll(pageable);
        TPage<UserDto> respnose = new TPage<UserDto>();
        respnose.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), UserDto[].class)));
        return respnose;
    }


    @Override
    public UserDto getByUsername(String username) {
    /*    User u = userRepository.findByUsername(username);
        return modelMapper.map(u, UserDto.class);*/

        return null;
    }

    public List<UserDto> getAll() {
        List<User> data = userRepository.findAll();
        return Arrays.asList(modelMapper.map(data, UserDto[].class));
    }

    @Transactional
    public Boolean register(RegistrationRequest registrationRequest)
    {
        try {
            User user = new User();
            user.setEmail(registrationRequest.getEmail());
            user.setSureName(registrationRequest.getNameSurname());
            user.setPassWord(bCryptPasswordEncoder.encode(registrationRequest.getPassword()));
            user.setUsername(registrationRequest.getUsername());
            userRepository.save(user);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("REGISTRATION=>", e);
            return Boolean.FALSE;
        }
    }
}
