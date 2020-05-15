package step2;

public enum Operator {

    PLUS("+", (result, nextNumber) -> result + nextNumber),
    MINUS("-", (result, nextNumber) -> result - nextNumber),
    MULTIPLY("*", (result, nextNumber) -> result * nextNumber),
    DIVIDE("/", (result, nextNumber) -> result / nextNumber);

    public String operator;
    public Calculator calculator;

    private Operator() {
        // block
    }

    Operator(String operator, Calculator calculator) {
        this.operator = operator;
        this.calculator = calculator;
    }

    static Operator of(String operator) {
        for (Operator op : Operator.values()) {
            if (op.operator.equals(operator)) {
                return op;
            }
        }
        throw new IllegalArgumentException();
    }

    int calculate(int result, int nextNumber) {
        return calculator.calculate(result, nextNumber);
    }


}



