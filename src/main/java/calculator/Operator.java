package calculator;

public enum Operator {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private String operatorString;

    Operator(String operatorString) {
        this.operatorString = operatorString;
    }

    public String getValue() {
        return operatorString;
    }

    public static Operator validateOperator(String operatorString) throws IllegalArgumentException {
        for (Operator operator : values()) {
            if (operator.getValue().equalsIgnoreCase(operatorString)) {
                return operator;
            }
        }
        PrintUtils.printErrorOperator();
        throw new IllegalArgumentException(Constant.ERROR_OPERATOR);
    }
}
