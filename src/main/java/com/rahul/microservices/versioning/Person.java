package com.rahul.microservices.versioning;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public Person(String name) {
        this.name = name;
    }
}
