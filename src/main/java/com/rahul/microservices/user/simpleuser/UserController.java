package com.rahul.microservices.user.simpleuser;

import com.rahul.microservices.user.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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


    //here we map getById method to getalluser moethod
    //output will be like this
    // "all-user": {
    //"href": "http://localhost:8080/users"
    //}

    @GetMapping("/userHATEOAS/{id}")
    public EntityModel<User> getUserUsingIdHATEOAS(@PathVariable Integer id) {
        User foundUser = userDaoService.findOne(id);
        if (foundUser == null) {
            throw new UserNotFoundException("Id");
        }
        EntityModel<User> enityModel = EntityModel.of(foundUser);
        WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        enityModel.add(linkBuilder.withRel("all-user"));
        return enityModel;
    }
}
