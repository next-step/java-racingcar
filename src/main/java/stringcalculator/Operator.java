package stringcalculator;

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

    private final String stringValue;
    private final BinaryExpression expression;
    static final String NOT_VALID_OPERATOR_EXCEPTION_MESSAGE = "Not valid operator string: ";
    static final Operator[] operators;

    static {

    }

    Operator(String stringValue, BinaryExpression expression) {
        this.stringValue = stringValue;
        this.expression = expression;
    }

    static {
        // for caching
        operators = values();
    }

    public static Operator from(String expression) {
        for (Operator operator : operators) {
            if (operator.stringValue.equals(expression)) {
                return operator;
            }
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
