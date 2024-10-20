package com.rahul.microservices.helloWorld;

import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource theMessageSource){
        this.messageSource = theMessageSource;
    }
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

    @RequestMapping(method =  RequestMethod.GET,path = "/hiInter")
    public String helloInternationlise(){
        Locale local = LocaleContextHolder.getLocale();
        return  messageSource.getMessage("good.morning.message", null,"Default Message",local);
     }
}
