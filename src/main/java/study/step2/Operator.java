package study.step2;

import java.util.Arrays;
import java.util.function.BiFunction;

enum Operator {
    plus("+", (left, right) -> left + right), //
    minus("-", (left, right) -> left - right), //
    multiply("*", (left, right) -> left * right), //
    divide("/", (left, right) -> {
        if (left % right != 0) {
            throw new IllegalArgumentException("나눗셈은 정수로 떨어져야 합니다.");
        }
        return left / right;
    });

    private final String sign;
    private final BiFunction<Long, Long, Long> operationImpl;

    Operator(String sign, BiFunction<Long, Long, Long> operationImpl) {
        this.sign = sign;
        this.operationImpl = operationImpl;
    }

    public static Operator valueOfSign(String sign) {
        return Arrays.stream(values()) //
                .filter(value -> value.sign.equals(sign)) //
                .findAny() //
                .orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다."));
    }

    public Long apply(Long left, Long right) {
        return operationImpl.apply(left, right);
    }
}
