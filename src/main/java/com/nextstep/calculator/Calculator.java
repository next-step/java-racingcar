package com.nextstep.calculator;

import java.util.List;

public class Calculator {
    public static int calculate(String input) {
        List<String> parsed = InputParser.parse(input);

        Number firstNumber = Number.stringToNumber(parsed.get(0));
        Number secondNumber = Number.stringToNumber(parsed.get(2));

        return operateDivider(firstNumber, secondNumber, parsed.get(1));
    }

    private static int operateDivider(Number firstNumber, Number secondNumber, String operator) {
        if (operator.equals("+")) {
            return firstNumber.plus(secondNumber).value();
        }
        if (operator.equals("-")) {
            return firstNumber.minus(secondNumber).value();
        }
        if (operator.equals("*")) {
            return firstNumber.multiply(secondNumber).value();
        }
        if (operator.equals("/")) {
            return firstNumber.divide(secondNumber).value();
        }

        return 0;
    }
}
