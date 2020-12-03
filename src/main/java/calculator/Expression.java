package calculator;

import java.util.Objects;

public class Expression {
    private final String[] operators;

    public Expression(String expression) {
        if(Objects.isNull(expression) || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("input data is empty");
        }
        this.operators = expression.split(" ");
    }

    public String of(int idx) {
        return operators[idx];
    }

    public int length() {
        return operators.length;
    }
}
