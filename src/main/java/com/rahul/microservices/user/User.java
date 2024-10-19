package com.rahul.microservices.user;

import org.springframework.cglib.core.Local;

public class User {
    private Integer id;
    private String name;
    private Local birthDay;

    public User(Integer id, String name, Local birthDay) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Local getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Local birthDay) {
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
