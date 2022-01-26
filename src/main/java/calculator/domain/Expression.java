package calculator.domain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Expression {

    private static final double INITIAL_RESULT_OF_CALCULATE = 0;

    private final LinkedList<String> numbers;
    private final List<String> operators;

    private double resultCalculate;

    public Expression(String expression) {
        //TODO: 방어적 복사본 사용할 것
        if (!Validator.checkValidate(expression)) {
            throw new IllegalArgumentException("[ERROR] 유효한 식이 아닙니다.");
        }

        expression = expression.replaceAll(" ", "");
        numbers = new LinkedList<>(Arrays.asList(expression.split("[-+*/]")));
        operators = Arrays.stream(expression.split("[0-9]+"))
            .filter(operand -> !operand.isEmpty())
            .collect(Collectors.toList());
        resultCalculate = INITIAL_RESULT_OF_CALCULATE;
    }

    public void calculate() {
        resultCalculate = convertNumber(numbers.poll());
        for (String operator : operators) {
            resultCalculate = Operation.calculate(operator, resultCalculate, convertNumber(numbers.poll()));
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
        System.out.println(resultCalculate);
    }
}
