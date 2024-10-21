package com.rahul.microservices.user.databaseUser;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity(name = "user_details")
public class UserEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 3, message = "Name should contain at least 3 character")
    private String name;

    @Past(message = "Birthday should be in the past")
    private LocalDate birthDate;

    public UserEntity() {
    }

    public UserEntity(Integer id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDate +
                '}';
    }
}

