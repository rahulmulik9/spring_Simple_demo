package com.rahul.microservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Version REST API
//1=> URI versioning
//2=> Request Parameter versioning
//3=>Custom header versioning
//4=> Content Negotiation Versioning
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

    //3=>Custom header versioning
    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")                 ///localhost:8080/person/header   //in psotmane choose header, key as X-API-VERSION and value 1
    public Person getFirstCustomeHeaderVersion(){
        return new Person("Rahul Mulik");
    }

    @GetMapping(path = "/person/header",headers = "X-API-VERSION=2")
    public Personv2 getSecondCustomeHeaderVersion(){
        return new Personv2("Rahul","Mulik");
    }

    //Content Negotiation Versioning
    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")              ///localhost:8080/person/header   //in psotmane choose header, key as accept and value application/vnd.company.app-v1+json
    public Person getFirstVersionOfPersonAcceptHeader() {
        return new Person("Rahul Mulik");
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public Personv2 getSecondVersionOfPersonAcceptHeader() {
        return new Personv2("Rahul","Mulik");
    }
}
