package com.rahul.microservices.filtering;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    //static filtering
    @GetMapping("/filterStat")
    public SomeBean filtering() {
        return new SomeBean("value1", "value2", "value3");
    }

    //dynamic filtering
    @GetMapping("filterDy")
    public MappingJacksonValue filteringDyanmic() {
        SomeBeanDy theBeam = new SomeBeanDy("value1", "value2", "value3");
        //you can also use list
        //List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"), new SomeBean("value4", "value5", "value6"));
        //MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(theBeam);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
        FilterProvider theProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        mappingJacksonValue.setFilters(theProvider);
        return mappingJacksonValue;
    }
}
