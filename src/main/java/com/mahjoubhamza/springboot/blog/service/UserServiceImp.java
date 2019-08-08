package com.mahjoubhamza.springboot.blog.service;

import com.mahjoubhamza.springboot.blog.model.User;
import com.mahjoubhamza.springboot.blog.repository.RoleRepository;
import com.mahjoubhamza.springboot.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/**
 * mim
 * 08/08/2019
 */
@Service
public class UserServiceImp implements UserService {

    private static final String USER_ROLE = "ROLE_USER";
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImp(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);

    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(User user) {
        User newUser=new User();
        newUser.setActive(1);
        newUser.setEmail(user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        String encodedPassword=passwordEncoder.encode(user.getPassword());
        newUser.setPassword(encodedPassword);
        newUser.setUsername(user.getUsername());
        //singletonList : immutable list containing only the specified object
        //Set Role to ROLE_USER
        newUser.setRoles(Collections.singletonList(roleRepository.findByRoleName(USER_ROLE)));
        return newUser;
    }
}
