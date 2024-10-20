package com.rahul.microservices.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Setter
@Getter
public class User {
    private Integer id;
    @Size(min = 3, message = "Name should contain at least 3 character")
    private String name;
    @Past(message = "Birthday should be in the past")
    private LocalDate birthDay;

    public User(Integer id, String name, LocalDate birthDay) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }
}
