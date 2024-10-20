package com.rahul.microservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Version REST API
//1=> URI versioning
//2=> Request Parameter versioning

@RestController
public class VersioningPersonController {

    //URI versioning
    @GetMapping("/v1/person")
    public Person getFirstVersion(){
        return new Person("Rahul Mulik");
    }
    @GetMapping("/v2/person")
    public Personv2 getSecondVersion(){
        return new Personv2("Rahul","Mulik");
    }

    //Request Parameter versioning
    @GetMapping(path = "/person",params = "version=1")                   ///localhost:8080/person?version=1
    public Person getFirstRequestParameterVersion(){
        return new Person("Rahul Mulik");
    }

    @GetMapping(path = "/person",params = "version=2")
    public Personv2 getSecondRequestParameterVersion(){
        return new Personv2("Rahul","Mulik");
    }
}
