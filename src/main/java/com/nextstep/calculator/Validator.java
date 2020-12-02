package com.nextstep.calculator;

public class Validator {

    public void validate(String input) {
        if ("".equals(input)) {
            throw new IllegalArgumentException("Empty string is not valid argument");
        }
        String[] temp = input.split(" ");
        if (temp.length % 2 == 0) {
            throw new IllegalArgumentException(input + " is not valid argument");
        }
        for( int ix = 0 ; ix < temp.length ; ix ++ ) {
            validate(ix, temp[ix]);
        }
    }

    private void validate(int ix, String str) {
        if (ix % 2 == 0) {
            checkNumber(str);
            return;
        }
        checkOperator(str);
    }

    private void checkNumber(String str) {
        final String REGEX = "\\d";
        if (!str.matches(REGEX)) {
            throw new IllegalArgumentException(str + " is not number");
        }
    }

    private void checkOperator(String str) {
        final String REGEX = "[+\\-*/]";
        if (!str.matches(REGEX)) {
            throw new IllegalArgumentException(str + " is not valid operator. ( +, -, *, / )");
        }
    }
}
