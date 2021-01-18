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
}
