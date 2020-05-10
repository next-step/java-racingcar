package calculator;

import calculator.constants.Operator;

import java.util.List;

public class StringCalculator implements Calculator {

    @Override
    public double calculate(String input) {
        List<String> arguments = Argument.toList(input);

        double result = Double.valueOf(arguments.get(0));

        for (int i = 1; i < arguments.size(); i += 2) {
            Operator operator = Operator.getOperator(arguments.get(i));
            double secondValue = Double.valueOf(arguments.get(i+1));
            result = operate(result, secondValue, operator);
        }
       return result;
    }

    private double operate(double a, double b, Operator operator) {
        if (operator == Operator.PLUS) return plus(a, b);
        if (operator == Operator.MINUS) return minus(a, b);
        if (operator == Operator.DIVIDE) return divide(a, b);
        if (operator == Operator.MULTIPLY) return multiply(a, b);

        throw new IllegalArgumentException("operator is not found");
    }
}
