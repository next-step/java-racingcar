package stringcalculator;

import stringcalculator.*;

import java.util.*;

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
        Operator op = Operator.getOperator(operator);
        return op.operate(firstOperand, secondOperand);
    }

}