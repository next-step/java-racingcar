package domain;

public class Calculator {

    private static int DIGIT_RANGE = 2;

    public double execute(String[] input) {
        double result = Double.parseDouble(input[0]);
        for (int i = 1; i < input.length; i += 2) {
            double operand = Double.parseDouble(input[i + 1]);
            result = calculate(input[i], result, operand);
        }
        return result;
    }

    private double calculate(String operator, double result, double operand) {
        if (operator.equals("+")) {
            return add(result, operand);
        }
        if (operator.equals("-")) {
            return subtract(result, operand);
        }
        if (operator.equals("*")) {
            return multiple(result, operand);
        }
        return divide(result, operand);
    }

    private double add(double number1, double number2) {
        return number1 + number2;
    }

    private double subtract(double number1, double number2) {
        return number1 - number2;
    }

    private double multiple(double number1, double number2) {
        return number1 * number2;
    }

    private double divide(double number1, double number2) {
        if (number2 == 0) {
            throw new IllegalArgumentException("[ERROR] 0으로 나눌 수 없습니다.");
        }
        return Math.round((number1 / number2) * Math.pow(10, DIGIT_RANGE)) / Math.pow(10,
            DIGIT_RANGE);
    }
}
