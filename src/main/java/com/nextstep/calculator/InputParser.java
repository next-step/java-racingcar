package com.nextstep.calculator;

public class InputParser {
    public static void validate(String input) {
        if (input == null) throw new IllegalArgumentException();
        if (input.trim().isEmpty()) throw new IllegalArgumentException();
    }
}
