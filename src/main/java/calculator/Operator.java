package calculator;

import java.util.function.BiFunction;

public enum Operator {
    ADDITION("+", (num1, num2) -> num1 + num2),
    SUBTRACTION("-", (num1, num2) -> num1 - num2),
    MULTIPLICATION("*", (num1, num2) -> num1 * num2),
    DIVISION("/", (num1, num2) -> {
        if (num2 == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return num1 / num2;
    });

    private final String sign;
    private final BiFunction<Integer, Integer, Integer> operation;

    Operator(String sign, BiFunction<Integer, Integer, Integer> operation) {
        this.sign = sign;
        this.operation = operation;
    }

    public static int operate(String sign, int num1, int num2) {
        Operator operator = getOperatorOf(sign);
        return operator.operation.apply(num1, num2);
    }

    private static Operator getOperatorOf(String sign) {
        for (Operator operator : Operator.values()) {
            if (operator.isEqualSign(sign)) {
                return operator;
            }
        }
        throw new IllegalArgumentException(String.format("존재하지 않는 부호입니다. (sign: %s)", sign));
    }

    private boolean isEqualSign(String sign) {
        return this.sign.equals(sign);
    }
}
