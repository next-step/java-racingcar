package step1.calculator;

public enum IntegerOperators implements Operators<Integer> {
    SUM((n1, n2) -> n1 + n2, "+"),
    SUBTRACT((n1, n2) -> n1 - n2, "-"),
    MULTIPLY((n1, n2) -> n1 * n2, "*"),
    DIVIDE((n1, n2) -> n1 / n2, "/");

    private final Operators<Integer> operation;
    private final String operator;

    IntegerOperators(Operators<Integer> operation, String operator) {
        this.operation = operation;
        this.operator = operator;
    }

    public String getOperator() {
        return this.operator;
    }

    @Override
    public Integer operation(Integer t1, Integer t2) {
        return operation.operation(t1, t2);
    }
}
