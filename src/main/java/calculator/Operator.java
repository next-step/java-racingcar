package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    ADD("+", Number::add),
    SUB("-", Number::subtract),
    MUL("*", Number::multiply),
    DIV("/", Number::dividedBy);

    private String sign;
    private BiFunction<Number, Number, Number> action;

    Operator(String sign, BiFunction<Number, Number, Number> action) {
        this.sign = sign;
        this.action = action;
    }

    static Operator of(String sign) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.sign.equals(sign))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 기호입니다."));
    }

    Number operate(Number first, Number second) {
        return this.action.apply(first, second);
    }

}
