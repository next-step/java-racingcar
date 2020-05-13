package com.cheolhyeonpark.step2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressionParser {

    public Expression getExpressionFromString(String input) {
        return new Expression(getNumbers(input), getOperators(input));
    }

    private String getBlankRemovedString(String input) {
        return input.replaceAll(" ", "");
    }

    private List<Integer> getNumbers(String input) {
        return Arrays.stream(getNumberStrings(getBlankRemovedString(input)))
                .map(this::getNumber)
                .collect(Collectors.toList());
    }

    private String[] getNumberStrings(String expression) {
        return expression.split("[+\\-*/]");
    }

    private Integer getNumber(String numberString) {
        try {
            return Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Wrong input! Only numbers and operators are allowed.");
        }
    }

    private List<Operator> getOperators(String input) {
        return Arrays.stream(getOperatorArray(getBlankRemovedString(input)))
                .map(Operator::getOperator)
                .collect(Collectors.toList());
    }

    private String[] getOperatorArray(String expression) {
        return expression.replaceAll("[0-9]", "").split("");
    }
}
