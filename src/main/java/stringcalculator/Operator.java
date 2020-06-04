package stringcalculator;

import java.util.HashMap;
import java.util.Map;

public enum Operator {
    ADDITION("+", (int a, int b) -> a + b),
    SUBTRACTION("-", (int a, int b) -> a - b),
    MULTIPLICATION("*", (int a, int b) -> a * b),
    DIVISION("/", (int a, int b) -> {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    });

    static final String NOT_VALID_OPERATOR_EXCEPTION_MESSAGE = "Not valid operator string: ";
    static final Map<String, Operator> operators;

    static {
        operators = new HashMap<>();
        for (Operator o : values()) {
            operators.put(o.stringValue, o);
        }
    }

    private final String stringValue;
    private final BinaryExpression expression;

    Operator(String stringValue, BinaryExpression expression) {
        this.stringValue = stringValue;
        this.expression = expression;
    }


    public static Operator from(String expression) {
        Operator operator = operators.get(expression);
        if (operator != null) {
            return operator;
        }
        throw new IllegalArgumentException(getErrorMessage(expression));
    }

    public int operate(int a, int b) {
        return this.expression.operate(a, b);
    }

    static String getErrorMessage(String expression) {
        return NOT_VALID_OPERATOR_EXCEPTION_MESSAGE + ": " + expression;
    }
}
