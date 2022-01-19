package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Expression {

    private List<String> numbers = new ArrayList<>();
    private List<String> operators = new ArrayList<>();

    private double result = 0;

    public Expression(String expression) {
        expression = expression.replaceAll(" ", "");
        numbers = Arrays.asList(expression.split("[-+*/]"));
        operators = Arrays.asList(expression.split("[0-9]+"));
        result = Integer.parseInt(numbers.get(0));
    }

    public void calculate() {
        for (int i = 1, size = numbers.size(); i < size; i++) {
            int operand = Integer.parseInt(numbers.get(i));
            String operator = operators.get(i);

            if (operator.equals("/") && operand == 0) {
                throw new ArithmeticException();
            }

            if (operator.equals("+")) {
                result = Operation.addition(result, operand);
                continue;
            }

            if (operator.equals("-")) {
                result = Operation.subtraction(result, operand);
                continue;
            }

            if (operator.equals("*")) {
                result = Operation.multiplication(result, operand);
                continue;
            }

            if (operator.equals("/")) {
                result = Operation.division(result, operand);
                continue;
            }
        }
    }

    public void printResult() {
        System.out.println("----------결과----------");
        System.out.println(result);
    }
}
