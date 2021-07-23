package calculator;

import java.util.Arrays;

public enum Operator {
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/");

    private String operator;

    Operator(String operator){
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public static Operator valueOfString(String str) {
        return Arrays.stream(Operator.values())
                .filter(i -> str.equals(i.getOperator()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
