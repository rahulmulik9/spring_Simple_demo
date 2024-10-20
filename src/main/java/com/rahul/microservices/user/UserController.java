package com.rahul.microservices.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    private UserDaoService userDaoService;

    public UserController(UserDaoService theUserDaoService) {
        this.userDaoService = theUserDaoService;
    }

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUserUsingId(@PathVariable Integer id) {
        User foundUser = userDaoService.findOne(id);
        if (foundUser == null) {
            throw new UserNotFoundException("Id");
        }
        return userDaoService.findOne(id);
    }

    @PostMapping("/user")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        userDaoService.creatNewUser(user);
        //redirect user to user/{id}
        URI userLocation = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(null).build();
    }


    @DeleteMapping("user/{id}")
    public void deleteUserUsingId(@PathVariable Integer id){
        userDaoService.deleteUsingId(id);

    }
}
