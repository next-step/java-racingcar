package calculator;

import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public enum Operator {
    PLUS("+", Operator::add),
    MINUS("-", Operator::subtract),
    MULTIPLY("*", Operator::multiply),
    DIVIDE("/", Operator::divide);

    private static final int ZERO_NUMBER = 0;
    private static final String REGEX_OPERATOR = "[\\*\\+-/]";
    private static final Pattern pattern = Pattern.compile(REGEX_OPERATOR);
    private String symbol;
    private DoubleBinaryOperator binaryOperator;

    Operator(String symbol, DoubleBinaryOperator binaryOperator) {
        this.symbol = symbol;
        this.binaryOperator = binaryOperator;
    }

    static boolean isOperator(String operation) {
        return pattern.matcher(operation).matches();
    }

    private static double add(double startNumber, double endNumber) {
        return startNumber + endNumber;
    }

    private static double subtract(double startNumber, double endNumber) {
        return startNumber - endNumber;
    }

    public static void checkZeroDivide(double endNumber) {
        if (endNumber == ZERO_NUMBER)
            throw new ArithmeticException("제로로 나누는건 허용되지 않습니다.");
    }

    private static double divide(double startNumber, double endNumber) {
        checkZeroDivide(endNumber);
        return startNumber / endNumber;
    }

    private static double multiply(double startNumber, double endNumber) {
        return startNumber * endNumber;
    }

    public static boolean isContains(String symbol) {
        return Arrays.stream(Operator.values())
                .map(Operator::getSymbol)
                .collect(Collectors.toList())
                .contains(symbol);
    }

    static void checkOperationSign(String operation) {
        if (!Operator.isOperator(operation)) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다. 사칙연산부호를 입력해주세요.");
        }
    }

    public static Operator getOperator(String letter) {
        switch (letter) {
            case "+":
                return PLUS;
            case "-":
                return MINUS;
            case "*":
                return MULTIPLY;
            case "/":
                return DIVIDE;
        }
        return null;
    }

    private String getSymbol() {
        return symbol;
    }

    public double apply(double startNumber, double endNumber) {
        return binaryOperator.applyAsDouble(startNumber, endNumber);
    }
}
