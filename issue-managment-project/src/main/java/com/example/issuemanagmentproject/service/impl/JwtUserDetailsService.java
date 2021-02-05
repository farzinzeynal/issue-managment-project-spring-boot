package com.example.issuemanagmentproject.service.impl;

import com.example.issuemanagmentproject.dto.RegistrationRequest;
import com.example.issuemanagmentproject.entity.User;
import com.example.issuemanagmentproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassWord(),
                new ArrayList<>());
    }

    public User save(RegistrationRequest user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassWord(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(newUser);
    }
}
