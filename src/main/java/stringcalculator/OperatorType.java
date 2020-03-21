package stringcalculator;

import java.util.function.Function;

public enum OperatorType {
    PLUS_OPERATOR("+"),
    MINUS_OPERATOR("-"),
    MULTIPLY_OPERATOR("*"),
    DIVIDE_OPERATOR("/");

    private String operator;

    OperatorType(String operator) {
        this.operator = operator;
    }

    public boolean isEqual(String operator) {
        return this.operator.equals(operator);
    }
}
