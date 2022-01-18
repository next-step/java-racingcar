package calculator.domain;

public class Operator {

    private final String operator;

    public Operator(String operator) {
        this.operator = operator;
    }

    public String value() {
        return operator;
    }

}
