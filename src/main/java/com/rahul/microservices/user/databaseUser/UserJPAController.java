package com.rahul.microservices.user.databaseUser;

import com.rahul.microservices.user.UserNotFoundException;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
public class UserJPAController {

    @Autowired
    private UserRepository userRepository;

    public UserJPAController( UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/jpa/users")
    public List<UserEntity> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/jpa/user/{id}")
    public EntityModel<UserEntity> getUserUsingId(@PathVariable Integer id) {
        Optional<UserEntity> foundUser = userRepository.findById(id);
        if (foundUser == null) {
            throw new UserNotFoundException("Id");
        }
        EntityModel<UserEntity> entity = EntityModel.of(foundUser.get());
        return entity;
    }



    @DeleteMapping("/jpauser/{id}")
    public void deleteUserUsingId(@PathVariable Integer id){
        userRepository.deleteById(id);
    }

    @PostMapping("/jpa/user")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserEntity user) {
        userRepository.save(user);
        //redirect user to user/{id}
        URI userLocation = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(null).build();
    }


//    //here we map getById method to getalluser moethod
//    //output will be like this
//    // "all-user": {
//    //"href": "http://localhost:8080/users"
//    //}
//
//    @GetMapping("/userHATEOAS/{id}")
//    public EntityModel<User> getUserUsingIdHATEOAS(@PathVariable Integer id) {
//        User foundUser = userDaoService.findOne(id);
//        if (foundUser == null) {
//            throw new UserNotFoundException("Id");
//        }
//        EntityModel<User> enityModel = EntityModel.of(foundUser);
//        WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).retrieveAllUsers());
//        enityModel.add(linkBuilder.withRel("all-user"));
//        return enityModel;
//    }
}
