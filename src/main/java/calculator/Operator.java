package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> {
        checkParameterIsZero(num1,num2);
        return num1 / num2;
    });

    private static void checkParameterIsZero(int num1, int num2) {
        if (num1 == 0 || num2 == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
    }

    private String operator;
    private BiFunction<Integer,Integer,Integer> expression;

    Operator(String operator, BiFunction<Integer,Integer,Integer> expression){
        this.operator = operator;
        this.expression = expression;
    }

    public static int calculate(int num1, String operator, int num2){
        return getOperator(operator).expression.apply(num1,num2);
    }

    private static Operator getOperator(String operator){
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(operator))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다."));
    }
}
