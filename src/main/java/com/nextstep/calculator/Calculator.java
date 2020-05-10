package com.nextstep.calculator;

import java.util.List;

public class Calculator {
    public static int calculate(String input) {
        List<String> parsed = InputParser.parse(input);

        Number firstNumber = Number.stringToNumber(parsed.get(0));
        Number secondNumber = Number.stringToNumber(parsed.get(2));

        if (parsed.get(1).equals("+")) {
            return firstNumber.plus(secondNumber).value();
        }
        if (parsed.get(1).equals("-")) {
            return firstNumber.minus(secondNumber).value();
        }
        if (parsed.get(1).equals("*")) {
            return firstNumber.multiply(secondNumber).value();
        }
        if (parsed.get(1).equals("/")) {
            return firstNumber.divide(secondNumber).value();
        }

        return 0;
    }
}
