package com.nextstep.calculator;

import java.util.List;

public class Calculator {
    public static int run(String input) {
        List<String> parsed = InputParser.parse(input);

        Number firstNumber = Number.stringToNumber(parsed.get(0));
        Number secondNumber = Number.stringToNumber(parsed.get(2));
        String operator = parsed.get(1);

        return calculate(firstNumber, secondNumber, operator).value();
    }

    private static Number calculate(Number firstNumber, Number secondNumber, String operator) {
        if (operator.equals("+")) {
            return firstNumber.plus(secondNumber);
        }
        if (operator.equals("-")) {
            return firstNumber.minus(secondNumber);
        }
        if (operator.equals("*")) {
            return firstNumber.multiply(secondNumber);
        }
        if (operator.equals("/")) {
            return firstNumber.divide(secondNumber);
        }

        throw new IllegalArgumentException("Please give valid operator");
    }
}
