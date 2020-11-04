package stringcalculator;

import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * Created By mand2 on 2020-11-03.
 * 계산식 처리 :enum으로 받아서 처리해도 될 것 같은데?
 */
public enum  Operator {
    PLUS("+", (first, second) -> first + second),
    MINUS("-", (first, second) -> first - second),
    MULTIPLY("*", (first, second) -> first * second),
    DIVIDE("/", (first, second) -> {
        if (first % second != 0) {
            throw new ArithmeticException("나눗셈은 정수로 나누어 떨어져야 합니다.");
        }
        return first / second;
    })
    ;

    private String operator;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static int calculate(int first, String operator, int second){
        try {
            return getOperator(operator).expression.apply(first, second);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
    }

    private static Operator getOperator(String operator) {
        return Arrays.stream(values())
                .filter(opr -> opr.operator.equals(operator))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("사칙연산 부호가 아닙니다."));
    }

}
