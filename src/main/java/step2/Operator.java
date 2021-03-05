package step2;

import java.util.Arrays;

public enum Operator {
    PLUS("+",(a,b) -> a+b),
    SUB("-",(a,b) -> a-b),
    DIV("/",(a,b) -> a/b),
    MUL("*",(a,b) -> a*b);

    private final String operator;

    private final OperatorInterface operations;

    Operator(String operator, OperatorInterface operations) {
        this.operator = operator;
        this.operations = operations;
    }

    public static Operator getOperator(String param){
        return Arrays.stream(Operator.values())
                .filter(o -> o.operator.equals(param))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다."));
    }

    public int apply(int a, int b){
        return this.operations.apply(a,b);
    }
}
