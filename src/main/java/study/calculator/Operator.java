package study.calculator;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Operator {

    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private String operator;
    private BiFunction<Integer, Integer, Integer> expression;
    private static final Map<String, Operator> BY_OPERATOR;


    static {
        BY_OPERATOR = Arrays.stream(values()).collect(Collectors.toMap(o -> o.operator, Function.identity()));
    }

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static Operator find(String operator) {
        return Optional.ofNullable(BY_OPERATOR.get(operator)).orElseThrow(IllegalArgumentException::new);
    }

    public Integer calculate(int num1, int num2) {
        return this.expression.apply(num1, num2);
    }
}
