package calculator;

import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;

public enum Operator {
    PLUS("+", Operator::add),
    MINUS("-", Operator::subtract),
    MULTIPLY("*", Operator::multiply),
    DIVIDE("/", Operator::divide);

    private static final double ZERO_NUMBER = 0.0;
    private final String symbol;
    private final DoubleBinaryOperator binaryOperator;

    Operator(String symbol, DoubleBinaryOperator binaryOperator) {
        this.symbol = symbol;
        this.binaryOperator = binaryOperator;
    }

    public static Operator getOperator(String letter) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.symbol.equals(letter))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("입력값이 잘못되었습니다. 사칙연산부호를 입력해주세요."));
    }

    public double apply(double startNumber, double endNumber) {
        return binaryOperator.applyAsDouble(startNumber, endNumber);
    }

    private static double add(double startNumber, double endNumber) {
        return startNumber + endNumber;
    }

    private static double subtract(double startNumber, double endNumber) {
        return startNumber - endNumber;
    }

    private static double divide(double startNumber, double endNumber) {
        checkZeroDivide(endNumber);
        return startNumber / endNumber;
    }

    private static void checkZeroDivide(double endNumber) {
        if (endNumber == ZERO_NUMBER)
            throw new ArithmeticException("제로로 나누는건 허용되지 않습니다.");
    }

    private static double multiply(double startNumber, double endNumber) {
        return startNumber * endNumber;
    }
}
