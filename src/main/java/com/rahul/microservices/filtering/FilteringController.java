package com.rahul.microservices.filtering;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

    @GetMapping("/filter")
    public SomeBean filtering(){
        return new SomeBean("value1", "value2","value3");
    }
}
