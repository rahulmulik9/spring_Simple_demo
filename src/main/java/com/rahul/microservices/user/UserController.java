package com.rahul.microservices.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserDaoService userDaoService;

    public UserController(UserDaoService theUserDaoService){
        this.userDaoService = theUserDaoService;
    }

    @GetMapping(path="/users")
    public List<User> retrieveAllUsers(){
        return userDaoService.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUserUsingId(@PathVariable Integer id){
        return userDaoService.findOne(id);
    }

    @PostMapping("/user")
    public void createUser(@RequestBody User user){
        userDaoService.creatNewUser(user);
    }
}
