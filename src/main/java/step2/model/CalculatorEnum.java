package step2.model;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum CalculatorEnum {
    ADD("+",(num1,num2) -> (num1 + num2)),
    MINUS("-",(num1,num2) -> (num1 - num2)),
    DIVIDE("/",(num1,num2)-> (num1 / num2)),
    MULTIPLY("*",(num1,num2)-> num1 * num2);

    private final BiFunction<Integer,Integer,Integer> expression;
    private final String operator;

    public static Integer findOperator(Integer num1, Integer num2, String operator) {
        return Arrays.stream(CalculatorEnum.values())
                .filter(calculatorEnum -> calculatorEnum.operator.equals(operator))
        .findAny()
        .orElse(checkOperator(operator)).expression.apply(num1,num2);
    }

    CalculatorEnum(String operator, BiFunction<Integer, Integer, Integer> expression){
        this.operator = operator;
        this.expression = expression;}

    public Integer calculate(Integer num1,Integer num2){
        return expression.apply(num1,num2); }

    private static CalculatorEnum checkOperator(String operator) {
        try {
            throw new RuntimeException("invalid operator");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
