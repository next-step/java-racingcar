package study;

import java.util.function.BiFunction;

public enum Operator {
    PLUS((num1 , num2) -> num1 + num2),
    MINUS((num1 , num2) -> num1 - num2);

    private BiFunction<Integer,Integer,Integer> calFunction;
    Operator(BiFunction<Integer, Integer, Integer> calFunction){
        this.calFunction = calFunction;
    }

    public int calculate(int a, int b) {
        return calFunction.apply(a, b);
    }

}
