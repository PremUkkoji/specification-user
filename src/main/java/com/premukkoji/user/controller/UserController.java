package com.premukkoji.user.controller;

import com.premukkoji.user.entity.User;
import com.premukkoji.user.model.FilterRequest;
import com.premukkoji.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("v1/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/lessthanage25")
    public List<User> getUsersLessThanAge25(){
        return userService.getUsersLessThanAge25();
    }

    @GetMapping("/users")
    public List<User> getAllUsers(@RequestBody FilterRequest filterRequest){
        return userService.getAllUsers(filterRequest);
    }

    @PostMapping("/user")
    public void createUser(@RequestBody User user){
        userService.save(user);
    }
}
