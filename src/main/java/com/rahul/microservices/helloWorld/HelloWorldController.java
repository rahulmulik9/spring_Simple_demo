package com.rahul.microservices.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    //old way mapping
    @RequestMapping(method =  RequestMethod.GET,path = "/hi")
    public String hello(){return "Hello World";}

    //new mapping with GetMapping
    @GetMapping(path="/hijson")
    public HelloWordBean helloJSON(){
        return new HelloWordBean("Hi There");
    }

}
