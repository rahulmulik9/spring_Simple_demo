package com.rahul.microservices.user.simpleuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class User {
    private Integer id;

    @Size(min = 3, message = "Name should contain at least 3 character")
    @JsonProperty("user_name")
    private String name;

    @Past(message = "Birthday should be in the past")
    @JsonProperty("birth_date")
    private LocalDate birthDate;

    public User(Integer id, String name, LocalDate birthDate) {
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
