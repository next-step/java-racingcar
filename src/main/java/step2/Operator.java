package step2;

public enum Operator {

    PLUS("+", (result, nextNumber, operator) -> result + nextNumber),
    MINUS("-", (result, nextNumber, operator) -> result - nextNumber),
    MULTIPLY("*", (result, nextNumber, operator) -> result * nextNumber),
    DIVIDE("/", (result, nextNumber, operator) -> result / nextNumber);

    private String operator;
    private Calculator calculator;

    Operator(String operator, Calculator calculator) {
        this.operator = operator;
        this.calculator = calculator;
    }

    public static int calculate(int result, int nextNumber, String operator) {
        for (Operator op : Operator.values()) {
            if (op.operator.equals(operator)) {
                return Calculator.calculate(result, nextNumber, operator);
            }
        }
        throw new IllegalArgumentException();
    }


}



