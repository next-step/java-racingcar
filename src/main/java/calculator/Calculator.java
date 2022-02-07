package calculator;

public class Calculator {

    private final String[] input;
    private double result;

    public Calculator(String[] input) {
        this.input = input;
        this.result = Double.parseDouble(input[0]);
    }

    public void execute() {
        for (int i = 1; i < input.length; i += 2) {
            double operand = Double.parseDouble(input[i + 1]);
            this.result = calculate(input[i], result, operand);
        }
    }

    public double getResult() {
        return result;
    }

    private static double calculate(String identifier, double result, double operand) {
        return Operator.calculate(identifier, result, operand);
    }
}


