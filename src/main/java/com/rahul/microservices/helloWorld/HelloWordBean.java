package com.rahul.microservices.helloWorld;

public class HelloWordBean {
    private String message;

    public HelloWordBean(String theMessage) {
        this.message = theMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String theMessage){
        message = theMessage;
    }

    @Override
    public String toString() {
        return "HelloWordBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
