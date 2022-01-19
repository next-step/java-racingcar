package domain;

import java.util.Arrays;
import java.util.function.BiFunction;

import static common.ErrorMessage.ERROR_MESSAGE_SIGN;

public enum Operator {
    PLUS("+", (number, operand) -> Operator.add(number, operand)),
    MINUS("-", (number, operand) -> Operator.sub(number, operand)),
    DIVIDE("/", (number, operand) -> Operator.divide(number, operand)),
    MULTIPLE("*", (number, operand) -> Operator.multiple(number, operand));


    private String sign;
    private BiFunction<Integer, Integer, Integer> operate;

    Operator(final String sign, final BiFunction<Integer, Integer, Integer> operate) {
        this.sign = sign;
        this.operate = operate;
    }

    public static Operator of(final String inputSign) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.sign.equals(inputSign))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_SIGN));
    }

    private static int add(final int number, final int operand) {
        return number + operand;
    }

    private static int sub(final int number, final int operand) {
        return number - operand;
    }

    private static int divide(final int number, final int operand) {
        return number / operand;
    }

    private static int multiple(final int number, final int operand) {
        return number * operand;
    }

    public int operate(final int number, final int operand) {
        return this.operate.apply(number, operand);
    }
}