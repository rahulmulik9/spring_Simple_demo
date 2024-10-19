package com.rahul.microservices.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(path = "/user/{id}")
    public User getUserUsingId(@PathVariable Integer id){
        return userDaoService.findOne(id);
    }


}
