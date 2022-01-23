package calculator;

public class Calculator {

    public double execute(String[] input) {
        double result = Double.parseDouble(input[0]);
        for (int i = 1; i < input.length; i += 2) {
            double operand = Double.parseDouble(input[i + 1]);
            result = calculate(input[i], result, operand);
        }
        return result;
    }

    private double calculate(String operatorElement, double result, double operand) {
        Operator operator = new Operator();

        switch (operatorElement) {
            case "+":
                return operator.add(result, operand);
            case "-":
                return operator.subtract(result, operand);
            case "*":
                return operator.multiple(result, operand);
            case "/":

        }
        return operator.divide(result, operand);
    }
}
