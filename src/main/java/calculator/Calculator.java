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

    private double calculate(String operatorElement, double result, double operand) {
        Operator operator = new Operator();

        if ("+".equals(operatorElement)) {
            return operator.add(result, operand);
        }
        if ("-".equals(operatorElement)) {
            return operator.subtract(result, operand);
        }
        if ("*".equals(operatorElement)) {
            return operator.multiple(result, operand);
        }
        if ("/".equals(operatorElement)) {
            return operator.divide(result, operand);
        }
        throw new IllegalArgumentException();
    }
}
