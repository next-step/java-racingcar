package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Expression {

    private final List<String> numbers;
    private final List<String> operators;

    private double result = 0;

    public Expression(String expression) {

        if (!Validator.checkValidate(expression)) {
            throw new IllegalArgumentException("[ERROR] 유효한 식이 아닙니다.");
        }

        expression = expression.replaceAll(" ", "");
        numbers = Arrays.asList(expression.split("[-+*/]"));
        operators = Arrays.asList(expression.split("[0-9]+"));
        result = Integer.parseInt(numbers.get(0));
    }

    public void calculate() {
        int numberSize = numbers.size();
        for (int i = 1; i < numberSize; i++) {
            final int operand = Integer.parseInt(numbers.get(i));
            result = Operation.calculate(operators.get(i), result, operand);
        }
    }

    public void printResult() {
        System.out.println("----------결과----------");
        System.out.println(result);
    }
}
