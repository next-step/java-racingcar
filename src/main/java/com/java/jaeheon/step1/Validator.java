package com.java.jaeheon.step1;

public class Validator {

    boolean isNotBlank(String input) {
        if (input == null || "".equals(input)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    void validateSize(int size) {
        if (size < 3 || !isOdd(size)) {
            throw new IllegalArgumentException();
        }
    }

    boolean isOdd(int size) {
        return size % 2 == 1;
    }

    boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

}