package com.rahul.microservices.helloWorld;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/hello/{theName}")
    public HelloWordBean hellowithName(@PathVariable String theName){
       // return new HelloWordBean("Hi "+theName);
        return new HelloWordBean(String.format("Hello , %s", theName));

    }
}
