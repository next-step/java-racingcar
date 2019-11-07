package step1.calculator;

public enum Operator {
    PLUS_OPERATOR("+"),
    MINUS_OPERATOR("-"),
    MULTIPLY_OPERATOR("*"),
    DIVIDE_OPERATOR("/");

    private String name;

    Operator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
