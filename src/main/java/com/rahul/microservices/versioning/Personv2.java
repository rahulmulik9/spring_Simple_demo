package com.rahul.microservices.versioning;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Personv2  {
    private String firstname;
    private String lastname;

    @Override
    public String toString() {
        return "Personv2{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public Personv2(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
