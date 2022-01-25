package calculator.domain;

import calculator.view.UserInput;
import java.util.List;

public class Calculator {
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLE = "*";
    private static final String DIVIDE = "/";

    private final Expression expression;

    public Calculator(UserInput userInput) {
        String input = userInput.getInput();
        this.expression = new Expression(input);
    }

    public void calculate() {
        List<String> numbers = expression.getNumbers();
        List<String> operators = expression.getOperators();
        double accumulator = Integer.parseInt(numbers.get(0));

        final int size = numbers.size();
        for (int i = 1; i < size; i++) {
            double operand = Integer.parseInt(numbers.get(i));
            String operator = operators.get(i);
            accumulator = getOperationResult(accumulator, operand, operator);
        }

        printResult(accumulator);
    }

    private double getOperationResult(double accumulator, double operand, String operator) {
        if(operator.equals(PLUS)) {
            return Operation.addition(accumulator, operand);
        }

        if(operator.equals(MINUS)) {
            return Operation.subtraction(accumulator, operand);
        }

        if(operator.equals(MULTIPLE)) {
            return Operation.multiplication(accumulator, operand);
        }

        if(operator.equals(DIVIDE)) {
            return Operation.division(accumulator, operand);
        }

        return 0;
    }

    public void printResult(double result) {
        System.out.println("----------결과----------");
        System.out.println(result);
    }
}
