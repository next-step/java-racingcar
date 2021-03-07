package step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLICATION("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> {
        Validator.checkZero(b);
        return a / b;
    });

    private String sign;
    private BiFunction<Long, Long, Long> formula;

    Operator(String sign, BiFunction<Long, Long, Long> formula) {
        this.sign = sign;
        this.formula = formula;
    }

    public long calculate(long a, String b) {
        Validator.checkDigit(b);
        return formula.apply(a, Long.parseLong(b));
    }

    public static Operator getOperator(String sign) {
        Validator.checkOperator(sign);
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.sign.equals(sign))
                .findFirst()
                .get();
    }

}
