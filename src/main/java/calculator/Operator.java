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
    private final Operate operate;

    Operator(String operator, Operate operate) {
        this.operator = operator;
        this.operate = operate;
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
        return operate.operate(a, b);
    }
}
