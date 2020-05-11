package calculator;

import java.util.Arrays;

public enum Operator {

    PLUS("+"),
    MINUS("-"),
    DIVIDE("/"),
    MULTIPLY("*");

    private String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public float calculate(float operand1, float operand2) {
        Calculator calculator = getCalculator(name());
        return calculator.calculate(operand1, operand2);
    }

    private Calculator getCalculator(String name) {
        switch (valueOf(name)) {
            case PLUS:
                return new PlusCalculator();
            case MINUS:
                return new MinusCalculator();
            case DIVIDE:
                return new DivideCalculator();
            case MULTIPLY:
                return new MultiplyCalculator();
            default:
                throw new IllegalArgumentException();
        }
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
