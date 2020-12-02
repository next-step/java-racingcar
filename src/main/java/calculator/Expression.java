package calculator;

import java.util.Objects;

public class Expression {
    private final String[] expression;

    public Expression(String expression) {
        if(Objects.isNull(expression) || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("input data is empty");
        }
        this.expression = expression.split(" ");
    }

    public String of(int num) {
        return expression[num];
    }

    public int length() {
        return expression.length;
    }


}
