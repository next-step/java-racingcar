package calculator.constants;

import java.util.Collections;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
    MULTIPLY("*", ((left, right) -> left * right)),
    DIVIDE("/", Operator::divide),
    PLUS("+", (left, right) -> left + right),
    MINUS("-", (left, right) -> left - right);

    private String symbol;
    private DoubleBinaryOperator doubleBinaryOperator;

    private static final Map<String, Operator> OPERATOR_CASH;

    static {
        OPERATOR_CASH = Collections.unmodifiableMap(
                Stream.of(Operator.values())
                        .collect(Collectors.toMap(Operator::getSymbol, operator -> operator))
        );
    }

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

    private static double divide(double left, double right) {
        if(right == 0) {
            throw new ArithmeticException("division with zero is not allowed.");
        }
        return left / right;
    }

    public static boolean isContains(String symbol) {
        return OPERATOR_CASH.containsKey(symbol);
    }

    public double apply(double firstValue, double secondValue) {
        return doubleBinaryOperator.applyAsDouble(firstValue, secondValue);
    }
}
