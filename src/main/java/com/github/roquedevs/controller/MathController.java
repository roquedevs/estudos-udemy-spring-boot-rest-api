package com.github.roquedevs.controller;

import com.github.roquedevs.service.MathService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/math")
public class MathController {

    public final MathService mathService = new MathService();

    @RequestMapping("/sum/{number1}/{number2}")
    public Double sum(@PathVariable("number1") String number1, @PathVariable("number2") String number2) {
        return mathService.sum(number1, number2);
    }

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        return mathService.subtract(numberOne, numberTwo);
    }

    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        return mathService.multiply(numberOne, numberTwo);
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        return mathService.divide(numberOne, numberTwo);
    }

    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        return mathService.mean(numberOne, numberTwo);
    }

    @RequestMapping("/square-root/{number}")
    public Double squareRoot(@PathVariable("number") String number) {
        return mathService.squareRoot(number);
    }
}