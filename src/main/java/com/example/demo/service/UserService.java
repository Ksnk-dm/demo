package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void insertUser(User user) {
        userRepository.save(user);
    }

//    public User findUserByName(String name) throws UsernameNotFoundException {
//        User user = userRepository.findUserByUserName(name);
//
//        if(user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//
//        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));
//
//        return new User(user.getUserName(), user.getPassword(), authorities);
//    }
}
