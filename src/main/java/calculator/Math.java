package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Math {

    ADDITION("+", (number1, number2) -> number1 + number2),
    SUBTRACTION("-", (number1, number2) -> number1 - number2),
    MULTIPLICATION("*", (number1, number2) -> number1 * number2),
    DIVISION("/", (number1, number2) -> number1 / number2);

    private String sign;

    private BiFunction<Long, Long, Long> expression;

    Math(String sign, BiFunction<Long, Long, Long> expression) {
        this.sign = sign;
        this.expression = expression;
    }

    private String getSign() {
        return this.sign;
    }

    public Long calculate(Long number1, Long number2) {
        return expression.apply(number1, number2);
    }

    public static Math createMath(String sign) {
        return Arrays.stream(Math.values()).filter(value -> StringUtils.equals(value.getSign(), sign)).findFirst().orElseThrow(IllegalArgumentException::new);
    }

}
