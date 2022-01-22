package calculator.domain;

import java.util.List;

public class Calculator {

    private static final String INVALID_OPERATION_LOG = "연산기호가 아닙니다.";

    private List<String> OperatorSymbols;

    private Calculator() {
        OperatorSymbols = Operator.SYMBOLS;
    }

    public static Calculator get() {
        return new Calculator();
    }

    public double doBinaryOperation(double num1, double num2, String operation) {
        if (!OperatorSymbols.contains(operation)) {
            throw new IllegalArgumentException(INVALID_OPERATION_LOG);
        }
        if (OperatorSymbols.get(0).equals(operation)) {
            return add(num1, num2);
        }
        if (OperatorSymbols.get(1).equals(operation)) {
            return subtract(num1, num2);
        }
        if (OperatorSymbols.get(2).equals(operation)) {
            return multiply(num1, num2);
        }
        return divide(num1, num2);
    }

    public double add(double num1, double num2) {
        return num1 + num2;
    }
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public double divide(double num1, double num2) {
        return num1 / num2;
    }

    public double doMultipleOperation(List<Integer> numbers, List<String> operator) {
        double result = numbers.remove(0);
        int numberSize = numbers.size();
        for (int i = 0; i < numberSize; i++){
            try {
                result = doBinaryOperation(result, (double) numbers.get(i), operator.get(i));
            } catch (Exception e) {

            }
        }
        return result;
    }
}
