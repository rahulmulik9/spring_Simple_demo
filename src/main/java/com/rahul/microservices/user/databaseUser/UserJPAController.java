package com.rahul.microservices.user.databaseUser;

import com.rahul.microservices.user.UserNotFoundException;
import com.rahul.microservices.user.post.Post;
import com.rahul.microservices.user.post.PostRepository;
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
    @Autowired
    private PostRepository postRepository;

    public UserJPAController(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
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
    public void deleteUserUsingId(@PathVariable Integer id) {
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


    @GetMapping("/jpa/user/{id}/posts")
    public List<Post> retrievePostForUser(@PathVariable Integer id) {
        Optional<UserEntity> foundUser = userRepository.findById(id);
        if (foundUser == null) {
            throw new UserNotFoundException("Id");
        }
        return foundUser.get().getPosts();
    }

    @PostMapping("/jpa/user/{id}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable Integer id,@Valid @RequestBody Post post) {
        Optional<UserEntity> foundUser = userRepository.findById(id);
        if (foundUser == null) {
            throw new UserNotFoundException("Id");
        }
        post.setUserEntity(foundUser.get());
        Post savedPost = postRepository.save(post);

        //redirect user to user/{id}
        URI userLocation = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(null).build();
    }
}
