package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum CalcOperator {

    ADD("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTI("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private final String sign;
    private final BiFunction<Integer, Integer, Integer> calcFunction;

    CalcOperator(String sign, BiFunction<Integer, Integer, Integer> biFunction) {
        this.sign = sign;
        this.calcFunction = biFunction;
    }

    public static CalcOperator find(String sign) {
        return Arrays.stream(values())
            .filter(signEnum -> signEnum.sign.equals(sign))
            .findAny()
            .orElseThrow(IllegalArgumentException::new);
    }

    public Integer calc(Integer a, Integer b) {
        return calcFunction.apply(a, b);
    }
}
