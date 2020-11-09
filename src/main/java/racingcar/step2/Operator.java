package racingcar.step2;

import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * Created : 2020-10-30 오전 10:44
 * Developer : Seo
 */
public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVISION("/", (x, y) -> x / y);

    private String operator;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public int calculate(Integer sum, String next) {
        return expression.apply(sum, Integer.parseInt(next));
    }

    public static Operator getOperator(String s) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.operator.equals(s))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
