package pobiStringCalculator;

public enum OperEnum {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTI("*", (x, y) -> x * y),
    DIVID("/", (x, y) -> x / y);


    private final String operator;
    private final Op op;

    OperEnum(String operator, Op operation) {
        this.operator = operator;
        this.op = operation;
    }

    public static boolean of(String s) {
        return false;
    }
}
