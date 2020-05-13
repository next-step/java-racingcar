package com.cheolhyeonpark.step2;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    public int calculate(String input) {
        validateInput(input);
        String expression = getExpression(input);
        List<Integer> numbers = getNumbers(expression);
        List<String> operators = getOperators(expression);
        validateExpression(numbers, operators);
        return getAnswer(numbers, operators);
    }

    private void validateInput(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("There is no input. Please check your input data.");
        }
    }

    private String getExpression(String input) {
        return input.replaceAll(" ", "");
    }

    private List<Integer> getNumbers(String expression) {
        String[] numberStrings = getNumberStrings(expression);
        return Arrays.stream(numberStrings).map(this::getNumber).collect(Collectors.toList());
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

    private List<String> getOperators(String expression) {
        return new ArrayList<>(Arrays.asList(getOperatorArray(expression)));
    }

    private String[] getOperatorArray(String expression) {
        return expression.replaceAll("[0-9]", "").split("");
    }

    private void validateExpression(List<Integer> numbers, List<String> operators) {
        if (!isRightExpression(numbers, operators)) {
            throw new IllegalArgumentException("Wrong input! Please check your input data.");
        }
    }

    private boolean isRightExpression(List<Integer> numbers, List<String> operators) {
        return numbers.size() - operators.size() == 1;
    }

    private int getAnswer(List<Integer> numbers, List<String> operators) {
        int result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            result = operate(operators.get(i), result, numbers.get(i + 1));
        }
        return result;
    }

    private int operate(String operator, int a, int b) {
        return Operator.getOperator(operator).operate(a, b);
    }
}
