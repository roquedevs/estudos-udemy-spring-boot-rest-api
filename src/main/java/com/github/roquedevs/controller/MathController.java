package com.github.roquedevs.controller;

import com.github.roquedevs.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{number1}/{number2}")
    public Double sum(@PathVariable("number1") String number1, @PathVariable("number2") String number2) {
        if (!isNumber(number1) || !isNumber(number2))
            throw new UnsupportedOperationException("Please enter a valid number");
        return convertToDouble(number1) + convertToDouble(number2);
    }

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        if (!isNumber(numberOne) || !isNumber(numberTwo))
            throw new UnsupportedMathOperationException("Please enter a valid number");
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        if (!isNumber(numberOne) || !isNumber(numberTwo)) throw new UnsupportedMathOperationException("Please enter a valid number");
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        if (!isNumber(numberOne) || !isNumber(numberTwo)) throw new UnsupportedMathOperationException("Please enter a valid number");
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        if (!isNumber(numberOne) || !isNumber(numberTwo)) throw new UnsupportedMathOperationException("Please enter a valid number");
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    @RequestMapping("/square-root/{number}")
    public Double squareRoot(@PathVariable("number") String number) {
        if (!isNumber(number)) throw new UnsupportedMathOperationException("Please enter a valid number");
        return Math.sqrt(convertToDouble(number));
    }

    private Double convertToDouble(String number) {
        if (number == null || number.isEmpty()) throw new UnsupportedOperationException("Please enter a valid number");
        number = number.trim();
        number = number.replace(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumber(String number) {
        if (number == null || number.isEmpty()) throw new UnsupportedOperationException("Please enter a valid number");
        number = number.replace(",", ".");
        return number.matches("[+-]?[0-9]*\\.?[0-9]+");
    }
}