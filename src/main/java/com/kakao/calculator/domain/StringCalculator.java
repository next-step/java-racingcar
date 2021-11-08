package com.kakao.calculator.domain;

public class StringCalculator {

    private final String DEFAULT_DELIMITER = " ";

    private String delimiter = DEFAULT_DELIMITER;

    public StringCalculator(String delimiter) {
        this.delimiter = delimiter;
    }

    public StringCalculator() {
    }

    public double calculate(String input) {
        String[] token = input.split(delimiter);
        return new Expression(token).execute().getValue();
    }
}
