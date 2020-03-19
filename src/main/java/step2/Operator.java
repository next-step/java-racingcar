package step2;

public enum Operator {

    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVISION("/");

    private final String value;

    Operator(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}

