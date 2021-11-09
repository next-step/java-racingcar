package step2.model;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum CalculatorEnum {
    ADD("+",(num1,num2) -> (num1 + num2)),
    MINUS("-",(num1,num2) -> (num1 - num2)),
    MULTIPLY("*",(num1,num2)-> num1 * num2),
    DIVIDE("/",(num1,num2)-> {
        if (num2 == 0) {
            throw new IllegalArgumentException("can't divide by zero");
        }
        return num1 / num2;
    });

    private final BiFunction<Integer,Integer,Integer> expression;
    private final String operator;

    CalculatorEnum(String operator, BiFunction<Integer, Integer, Integer> expression){
        this.operator = operator;
        this.expression = expression;}

    public static Integer findOperator(Integer num1, Integer num2, String operator) {
        return Arrays.stream(values())
                .filter(calculatorEnum -> calculatorEnum.operator.equals(operator))
        .findAny()
        .orElseThrow(() -> new IllegalArgumentException("invalid operator")).expression.apply(num1,num2);
    }
}
