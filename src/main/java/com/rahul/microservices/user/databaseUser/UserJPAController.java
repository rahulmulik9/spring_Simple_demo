package com.rahul.microservices.user.databaseUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

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
//
//    @GetMapping("/jpa/user/{id}")
//    public User getUserUsingId(@PathVariable Integer id) {
//        User foundUser = userDaoService.findOne(id);
//        if (foundUser == null) {
//            throw new UserNotFoundException("Id");
//        }
//        return userDaoService.findOne(id);
//    }
//
//    @PostMapping("/jpa/user")
//    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
//        userDaoService.creatNewUser(user);
//        //redirect user to user/{id}
//        URI userLocation = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(user.getId())
//                .toUri();
//        return ResponseEntity.created(null).build();
//    }
//
//
//    @DeleteMapping("/jpauser/{id}")
//    public void deleteUserUsingId(@PathVariable Integer id){
//        userDaoService.deleteUsingId(id);
//
//    }
//
//
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
