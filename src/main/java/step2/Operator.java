package step2;

public enum Operator {

    PLUS("+", (result, nextNumber, operator) -> result + nextNumber),
    MINUS("-", (result, nextNumber, operator) -> result - nextNumber),
    MULTIPLY("*", (result, nextNumber, operator) -> result * nextNumber),
    DIVIDE("/", (result, nextNumber, operator) -> result / nextNumber);

    private String operator;
    public Calculator calculator;

    private Operator() {
        // block
    }

    Operator(String operator, Calculator calculator) {
        this.operator = operator;
        this.calculator = calculator;
    }

    static int calculate(int result, int nextNumber, String operator) {
        for (Operator op : Operator.values()) {
            if (op.operator.equals(operator)) {
                return op.calculator.calculate(result, nextNumber, operator);
            }
        }
        throw new IllegalArgumentException();
    }

}



