package calculator;

import java.util.Arrays;

public enum Operator {

    PLUS("+", (beforeOperand, nextOperand) -> beforeOperand + nextOperand),
    MINUS("-", (beforeOperand, nextOperand) -> beforeOperand - nextOperand),
    DIVIDE("/", (beforeOperand, nextOperand) -> beforeOperand / nextOperand),
    MULTIPLY("*", (beforeOperand, nextOperand) -> beforeOperand * nextOperand);

    private String symbol;
    private Calculator calculator;

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
        Operator[] operators = values();
        for(Operator op : operators) {
            if(op.getSymbol().equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("This operation is not supported :  " + symbol);
    }

    public static boolean isOperatorSymbol(String symbol) {
        return Arrays.stream(values())
                .anyMatch(operator -> operator.getSymbol().equals(symbol));
    }
}
