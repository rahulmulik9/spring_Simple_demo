package com.rahul.microservices.user.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rahul.microservices.user.databaseUser.UserEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue
    private Integer id;
    @Size(min=10)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private UserEntity userEntity;

    public Post(Integer id, String description) {
        this.id = id;
        this.description = description;
    }
}
