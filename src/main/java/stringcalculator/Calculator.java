package stringcalculator;

import java.util.Objects;
import java.util.Scanner;

public class Calculator {
    public int calculate(String input) {
        if (isNullOrBlank(input)) {
            throw new IllegalArgumentException(Constants.INPUT_VALUE_IS_NULL_OR_EMPTY);
        }
        String[] expressions = input.split(" ");

        int firstOperand = Integer.parseInt(expressions[0]);

        for (int i = 1; i < expressions.length; i = i + 2) {
            firstOperand = calculate(firstOperand, Integer.parseInt(expressions[i + 1]), expressions[i]);
        }

        return firstOperand;
    }

    private boolean isNullOrBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    private int calculate(int firstOperand, int secondOperand, String operator) {
        if (operator.equals("+")) {
            return add(firstOperand, secondOperand);
        } else if (operator.equals("-")) {
            return subtract(firstOperand, secondOperand);
        } else if (operator.equals("*")) {
            return multiple(firstOperand, secondOperand);
        } else if (operator.equals("/")) {
            return divide(firstOperand, secondOperand);
        }
        throw new IllegalArgumentException(Constants.IS_NOT_VALID_OPERATOR);

    }

    private int add(int firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }

    private int subtract(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }

    private int multiple(int firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }

    private int divide(int firstOperand, int secondOperand) {
        if (secondOperand == 0) {
            throw new ArithmeticException(Constants.DIVIDE_BY_ZERO);
        }
        return firstOperand / secondOperand;
    }

}