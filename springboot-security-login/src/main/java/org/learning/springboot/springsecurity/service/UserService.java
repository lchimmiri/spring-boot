package org.learning.springboot.springsecurity.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.learning.springboot.springsecurity.model.User;
import org.learning.springboot.springsecurity.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
