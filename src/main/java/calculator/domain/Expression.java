package calculator.domain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Expression {

    private final LinkedList<String> numbers;
    private final List<String> operators;

    private double result = 0;

    public Expression(String expression) {

        if (!Validator.checkValidate(expression)) {
            throw new IllegalArgumentException("[ERROR] 유효한 식이 아닙니다.");
        }

        expression = expression.replaceAll(" ", "");
        numbers = new LinkedList<>(Arrays.asList(expression.split("[-+*/]")));
        operators = Arrays.asList(expression.split("[0-9]+"))
            .stream().filter(operand -> !operand.isEmpty())
            .collect(Collectors.toList());
    }

    public void calculate() {
        result = convertNumber(numbers.poll());
        for (String operator : operators) {
            result = Operation.calculate(operator, result, convertNumber(numbers.poll()));
        }
    }

    private int convertNumber(String number) {
        if (Objects.isNull(number)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(number);
    }

    public void printResult() {
        System.out.println("----------결과----------");
        System.out.println(result);
    }
}
