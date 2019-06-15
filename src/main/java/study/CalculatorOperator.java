package study;

import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * Created by wyparks2@gmail.com on 2019-06-15
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public enum CalculatorOperator {
    ADD("+", "더하기", (left, right) -> left + right),
    SUBTRACT("-", "빼기", (left, right) -> left - right),
    MULTIPLY("*", "곱하기", (left, right) -> left * right),
    DIVIDE("/", "나누기", (left, right) -> left / right);

    CalculatorOperator(String text, String discription,
                       BiFunction<Integer, Integer, Integer> expression) {
        this.text = text;
        this.discription = discription;
        this.expression = expression;
    }

    private String text;
    private String discription;
    private BiFunction<Integer, Integer, Integer> expression;

    public static CalculatorOperator fromString(String text) {
        return Arrays.stream(CalculatorOperator.values())
                .filter(calculatorOperation -> calculatorOperation.text.equals(text))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("허용된 연산자가 아닙니다. " + text));
    }

    public int calculator(int left, int right) {
        return this.expression.apply(left, right);
    }
}
