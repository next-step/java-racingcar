package study;

import java.util.function.BiFunction;

public enum Operations {
    PLUS("+",(a,b)->a+b),
    MINUS("-",(a,b)->a-b),
    MULTIPLY("*",(a,b)->a*b),
    DIVIDE("/",(a,b)->a/b);

    private String symbol;
    private BiFunction<Integer,Integer,Integer> biFunction;
    Operations(String symbol,BiFunction<Integer,Integer,Integer> biFunction){
        this.symbol = symbol;
        this.biFunction = biFunction;
    }

    public static String findSymbol(String operation){
        for(Operations oper : Operations.values()){
            if(oper.symbol.equals(operation)){
                return oper.name();
            }
        }
        throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }

    public Integer calculate(Integer leftOperand,Integer rightOperand){
        return this.biFunction.apply(leftOperand,rightOperand);
    }


}
