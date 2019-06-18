package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Math {

    ADDITION("+", (arg1, arg2) -> arg1 + arg2),
    SUBTRACTION("-", (arg1, arg2) -> arg1 - arg2),
    MULTIPLICATION("*", (arg1, args2) -> arg1 * args2),
    DIVISION("/", (arg1, arg2) -> arg1 / arg2);

    private String sign;

    private BiFunction<Long, Long, Long> expression;

    Math(String sign, BiFunction<Long, Long, Long> expression) {
        this.sign = sign;
        this.expression = expression;
    }


    private Long calculate(final Long arg1, final Long arg2) {
        return expression.apply(arg1, arg2);
    }

    private static Math getBySign(final String sign) {
        return Arrays.stream(Math.values())
                .filter(math -> StringUtils.equals(math.sign, sign))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static String getBySignAndCalculate(final Long arg1, final String sign, final Long arg2) {
        return getBySign(sign).calculate(arg1, arg2).toString();
    }

}
