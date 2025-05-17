package com.github.roquedevs.service;

import com.github.roquedevs.util.NumberUtils;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Double sum(String numberOne, String numberTwo) {
        NumberUtils.validate(numberOne, numberTwo);
        return NumberUtils.toDouble(numberOne) + NumberUtils.toDouble(numberTwo);
    }

    public Double subtract(String numberOne, String numberTwo) {
        NumberUtils.validate(numberOne, numberTwo);
        return NumberUtils.toDouble(numberOne) - NumberUtils.toDouble(numberTwo);
    }

    public Double multiply(String numberOne, String numberTwo) {
        NumberUtils.validate(numberOne, numberTwo);
        return NumberUtils.toDouble(numberOne) * NumberUtils.toDouble(numberTwo);
    }

    public Double divide(String numberOne, String numberTwo) {
        NumberUtils.validate(numberOne, numberTwo);
        return NumberUtils.toDouble(numberOne) / NumberUtils.toDouble(numberTwo);
    }

    public Double mean(String numberOne, String numberTwo) {
        NumberUtils.validate(numberOne, numberTwo);
        return (NumberUtils.toDouble(numberOne) + NumberUtils.toDouble(numberTwo)) / 2;
    }

    public Double squareRoot(String number) {
        NumberUtils.validate(number);
        return Math.sqrt(NumberUtils.toDouble(number));
    }
}
