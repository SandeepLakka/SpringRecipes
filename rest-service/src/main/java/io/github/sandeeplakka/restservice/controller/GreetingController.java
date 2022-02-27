package io.github.sandeeplakka.restservice.controller;

import io.github.sandeeplakka.restservice.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

//RestController is @Controller + @ResponseBody
@RestController
public class GreetingController {

    public static final String TEMPLATE = "Hello, %s";
    private final AtomicLong COUNTER = new AtomicLong();

    //GetMapping is variant of RequestMapping as follows
    //@RequestMapping(method = RequestMethod.GET, value = "/greeting")
    @GetMapping("/greeting")
    //@RequestParam handles the request params in the URL (...*?<..>)
    //Other variant is @PathParam which handles path params (../<..>/)
    //We can make this required param by setting required to true
    //We can give default values if in case of null values, for empty values, empty is picked up
    public Greeting greet(@RequestParam(value = "name", defaultValue = "World") String name){
        //Marshalling is done thru Jackson http message converters
        //MappingJackson2HttpMessageConverter is automagically loaded to do this by spring boot
        return new Greeting(COUNTER.incrementAndGet(), String.format(TEMPLATE, name));
    }
}
