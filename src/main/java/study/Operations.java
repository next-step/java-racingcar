package study;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operations {
    PLUS("+" , (a , b)-> a + b),
    MINUS("-", (a , b)-> a - b),
    MULTIPLY("*", (a , b)-> a * b),
    DIVIDE("/", (a , b)-> a / b);

    private String symbol;
    private BiFunction<Integer,Integer,Integer> biFunction;

    Operations(String symbol,BiFunction<Integer,Integer,Integer> biFunction){
        this.symbol = symbol;
        this.biFunction = biFunction;
    }
    public static Operations getOperator(String operation){
        return Arrays.stream(Operations.values())
                .filter(op->op.symbol.equals(operation))
                .findAny()
                .orElseThrow(()->new IllegalArgumentException("사칙연산 기호가 아닙니다."));
    }
    public Integer calculate(Integer leftOperand,Integer rightOperand){
        return biFunction.apply(leftOperand,rightOperand);
    }
}
