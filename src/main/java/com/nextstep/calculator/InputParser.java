package com.nextstep.calculator;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    protected static void validate(String input) {
        if (input == null) throw new IllegalArgumentException();
        if (input.trim().isEmpty()) throw new IllegalArgumentException();
    }

    public static List<String> parse(String input) {
        validate(input);
        return Arrays.asList(input.split(" "));
    }
}
