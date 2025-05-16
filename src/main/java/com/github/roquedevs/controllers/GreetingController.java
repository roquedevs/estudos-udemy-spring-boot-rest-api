package com.github.roquedevs.controllers;

import com.github.roquedevs.models.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @RestController é um alias para as anotations
 * @Controller e @ResponseBody do Spring Framework
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "World!!!!")
            String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}