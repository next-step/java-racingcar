package calculator;

import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;
import java.util.stream.Collectors;

public enum Operator {
    PLUS("+", Operator::add),
    MINUS("-", Operator::subtract),
    MULTIPLY("*", Operator::multiply),
    DIVIDE("/", Operator::divide);

    private String symbol;
    private DoubleBinaryOperator binaryOperator;

    Operator(String symbol, DoubleBinaryOperator binaryOperator) {
        this.symbol = symbol;
        this.binaryOperator = binaryOperator;
    }

    private static double add(double startNumber, double endNumber) {
        return startNumber + endNumber;
    }

    private static double subtract(double startNumber, double endNumber) {
        return startNumber - endNumber;
    }

    private static void checkZeroDivide(double endNumber) {
        if (endNumber == Calculator.ZERO_NUMBER)
            throw new ArithmeticException("제로로 나누는건 허용되지 않습니다.");
    }

    private static double divide(double startNumber, double endNumber) {
        checkZeroDivide(endNumber);
        return startNumber / endNumber;
    }

    private static double multiply(double startNumber, double endNumber) {
        return startNumber * endNumber;
    }

    public static boolean isContains(String symbol){
        return Arrays.stream(Operator.values())
                .map(Operator::getSymbol)
                .collect(Collectors.toList())
                .contains(symbol);
    }

    private String getSymbol() {
        return symbol;
    }

    public double apply(int startNumber, int endNumber) {
        return binaryOperator.applyAsDouble(startNumber, endNumber);
    }
}
