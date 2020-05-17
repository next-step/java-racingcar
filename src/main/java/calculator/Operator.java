package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Operator {

    PLUS("+", (beforeOperand, nextOperand) -> beforeOperand + nextOperand),
    MINUS("-", (beforeOperand, nextOperand) -> beforeOperand - nextOperand),
    DIVIDE("/", (beforeOperand, nextOperand) -> {
        if(nextOperand == 0) {
            throw new ArithmeticException("It cannot be divided by zero.");
        }
        return beforeOperand / nextOperand;
    }),
    MULTIPLY("*", (beforeOperand, nextOperand) -> beforeOperand * nextOperand);

    private String symbol;
    private Calculator calculator;

    private static final Map<String, Operator> OPERATORS =
        Collections.unmodifiableMap(
            Arrays.stream(values()).collect(Collectors.toMap(Operator::getSymbol, Function.identity()))
        );

    Operator(String symbol, Calculator calculator) {
        this.symbol = symbol;
        this.calculator = calculator;
    }

    public String getSymbol() {
        return symbol;
    }

    public float calculate(float beforeOperand, float nextOperand) {
        return calculator.calculate(beforeOperand, nextOperand);
    }

    public static Operator getOperator(String symbol) {
        Operator operator = OPERATORS.get(symbol);
        if(operator == null) {
            throw new IllegalArgumentException("This operation is not supported :  " + symbol);
        }
        return operator;
    }

}
