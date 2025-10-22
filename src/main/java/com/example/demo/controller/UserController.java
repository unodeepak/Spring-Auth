package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.utils.JwtUtils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/create-user")
    public Map<String, Object> createUser(@RequestBody User user) {
        Map<String, Object> resp = new HashMap<>();
        userRepository.save(user);
        String token = jwtUtils.generateToken(user.getFirst_name());

        resp.put("msg", "New User Created");
        resp.put("statusCode", 201);        
        resp.put("token", token);

        return resp;
    }

    @GetMapping("/get-users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    

}
