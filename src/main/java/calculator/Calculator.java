package calculator;

import java.util.List;

public class Calculator {

    public double execute(List<String> input) {
        double result = Double.parseDouble(input.get(0));
        for (int i = 1; i < input.size(); i += 2) {
            double operand = Double.parseDouble(input.get(i + 1));
            result = calculate(input.get(i), result, operand);
        }
        return result;
    }

    private double calculate(String symbol, double number1, double number2) {
        return Operator.operatorOf(symbol).apply(number1, number2);
    }
}