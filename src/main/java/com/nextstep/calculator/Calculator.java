package com.nextstep.calculator;

import java.util.List;

public class Calculator {
    public static int run(String input) {
        List<String> parsed = InputParser.parse(input);

        Number result = Number.stringToNumber(parsed.get(0));

        for (int i = 1; i < parsed.size() - 1; i += 2) {
            Number secondNumber = Number.stringToNumber(parsed.get(i + 1));
            String operator = parsed.get(i);

            result = numberCalculate(result, secondNumber, operator);
        }

        return result.value();
    }

    private static Number numberCalculate(Number firstNumber, Number secondNumber, String operator) {
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
        throw new IllegalArgumentException();
    }
}
