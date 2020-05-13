package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum Operator {

    PLUS("+", (beforeOperand, nextOperand) -> beforeOperand + nextOperand),
    MINUS("-", (beforeOperand, nextOperand) -> beforeOperand - nextOperand),
    DIVIDE("/", (beforeOperand, nextOperand) -> beforeOperand / nextOperand),
    MULTIPLY("*", (beforeOperand, nextOperand) -> beforeOperand * nextOperand);

    private String symbol;
    private Calculator calculator;

    private static final Map<String, Operator> operators;
    static {
        Map<String, Operator> map = new HashMap<>();
        for(Operator op : values()) {
            map.put(op.getSymbol(), op);
        }
        operators = Collections.unmodifiableMap(map);
    }

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
        Operator operator = operators.get(symbol);
        if(operator == null) {
            throw new IllegalArgumentException("This operation is not supported :  " + symbol);
        }
        return operator;
    }

    public static boolean isOperatorSymbol(String symbol) {
        return Arrays.stream(values())
                .anyMatch(operator -> operator.getSymbol().equals(symbol));
    }
}
