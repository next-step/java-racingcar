package calculator;

import java.util.function.BiFunction;

public enum CalculatorSign {
    SUM((value1, value2)-> value1 + value2)
    ,MINUS((value1, value2)-> value1 - value2)
    ,MULTIPLY((value1, value2)-> value1 * value2)
    ,DIVIDE((value1, value2)-> value1 / value2);


    private BiFunction<Integer,Integer,Integer> function;

    CalculatorSign(BiFunction<Integer,Integer,Integer> function) {
        this.function = function;
    }

    public int calculate(Integer number1, Integer number2){
        return function.apply(number1,number2);
    }
}
