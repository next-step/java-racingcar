package calculator;

public enum Operator {

    PLUS("+", Integer::sum),
    MINUS("-", (a, b) -> a - b),
    MULTIPLE("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if (b == 0) {
            throw new IllegalArgumentException();
        }
        return a / b;
    });

    private final String operator;
    private final Op op;

    Operator(String operator, Op op) {
        this.operator = operator;
        this.op = op;
    }

    public static Operator from(String value) {
        for (Operator op : Operator.values()) {
            if (op.operator.equals(value)) {
                return op;
            }
        }
        throw new IllegalArgumentException();
    }

    public String getOperator() {
        return operator;
    }

    public int operate(int a, int b) {
        return op.operate(a, b);
    }
}
