package study.step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLICATION("*", (x, y) -> x * y),
    DIVISION("/", (x, y) -> x / y);

    String operator;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }


    static boolean isOperator(String str) {
        return Arrays.stream(Operator.values()).anyMatch(v -> v.operator.equals(str));
    }


    int calculate(int firstNum, int secondNum) {
        return expression.apply(firstNum, secondNum);
    }


    static Operator valueOfStr(String str) {
        return Arrays.stream(Operator.values())
                .filter(v -> v.operator.equals(str))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
