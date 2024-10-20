package com.rahul.microservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SomeBean {
    private String field1;
    @JsonIgnore                       //on browser when API hit, it wont show the filed2
    private String field2;
    private String field3;

    public SomeBean(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }
}

//   @JsonIgnoreProperties("field2","field3")                        //you can also ignore at class level
//   public class SomeBean {

//best way to use only @JsonIgnore above variables
