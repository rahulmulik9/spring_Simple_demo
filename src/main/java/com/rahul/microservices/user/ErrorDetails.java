package com.rahul.microservices.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class ErrorDetails {
    private LocalDate timeStamp;
    private String message;
    private String details;

    public ErrorDetails(LocalDate timeStamp, String message, String details) {
        super();
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }
}
