package calculator.constants;

import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;
import java.util.stream.Collectors;

public enum Operator {
    MULTIPLY("*", Operator::multiply),
    DIVIDE("/", Operator::divide),
    PLUS("+", Operator::plus),
    MINUS("-", Operator::minus);

    private String symbol;
    private DoubleBinaryOperator doubleBinaryOperator;

    Operator(String symbol, DoubleBinaryOperator doubleBinaryOperator) {
        this.symbol = symbol;
        this.doubleBinaryOperator = doubleBinaryOperator;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Operator getOperator(String symbol) {
        switch (symbol) {
            case "*":
                return MULTIPLY;
            case "/":
                return DIVIDE;
            case "+":
                return PLUS;
            case "-":
                return MINUS;
        }
        return null;
    }

    private static double plus(double firstValue, double secondValue) {
        return firstValue + secondValue;
    }

    private static double minus(double firstValue, double secondValue) {
        return firstValue - secondValue;
    }

    private static double multiply(double firstValue, double secondValue) {
        return firstValue * secondValue;
    }

    private static double divide(double firstValue, double secondValue) {
        if(secondValue == 0) {
            throw new ArithmeticException("division with zero is not allowed.");
        }
        return firstValue / secondValue;
    }


    public static boolean isContains(String symbol) {
        return Arrays.stream(Operator.values())
                .map(Operator::getSymbol)
                .collect(Collectors.toList())
                .contains(symbol);
    }

    public double apply(double firstValue, double secondValue) {
        return doubleBinaryOperator.applyAsDouble(firstValue, secondValue);
    }
}
