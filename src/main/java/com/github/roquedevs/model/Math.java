package com.github.roquedevs.model;

import com.github.roquedevs.exception.UnsupportedMathOperationException;

import java.io.Serial;
import java.io.Serializable;
import static java.lang.Math.sqrt;

public class Math implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

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

    public Double sum(String number1, String number2) {
        if (!isNumber(number1) || !isNumber(number2)) throw new UnsupportedOperationException("Please enter a valid number");
        return convertToDouble(number1) + convertToDouble(number2);
    }

    public Double subtraction(String numberOne, String numberTwo) {
        if (!isNumber(numberOne) || !isNumber(numberTwo)) throw new UnsupportedMathOperationException("Please enter a valid number");
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    public Double multiplication(String numberOne, String numberTwo) {
        if (!isNumber(numberOne) || !isNumber(numberTwo)) throw new UnsupportedMathOperationException("Please enter a valid number");
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    public Double division(String numberOne, String numberTwo) {
        if (!isNumber(numberOne) || !isNumber(numberTwo)) throw new UnsupportedMathOperationException("Please enter a valid number");
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    public Double mean(String numberOne, String numberTwo) {
        if (!isNumber(numberOne) || !isNumber(numberTwo)) throw new UnsupportedMathOperationException("Please enter a valid number");
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    public Double squareRoot(String number) {
        if (!isNumber(number)) throw new UnsupportedMathOperationException("Please enter a valid number");
        return sqrt(convertToDouble(number));
    }
}
