package com.github.roquedevs.util;

public class NumberUtils {

    public static boolean isNumeric(String str) {
        if (str == null || str.trim().isEmpty()) return false;
        return str.trim().replace(",", ".").matches("[+-]?[0-9]*\\.?[0-9]+");
    }

    public static Double toDouble(String str) {
        if (str == null || str.trim().isEmpty()) throw new UnsupportedOperationException("Please enter a valid number");
        return Double.parseDouble(str.trim().replace(",", "."));
    }

    public static void validate(String... numbers) {
        for (String number : numbers) {
            if (!isNumeric(number)) {
                throw new UnsupportedOperationException("Please enter a valid number");
            }
        }
    }
}
