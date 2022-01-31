package stringcalculator.domain;

import static stringcalculator.common.ErrorMessage.ERROR_MESSAGE_DIVIDE;
import static stringcalculator.common.ErrorMessage.ERROR_MESSAGE_SIGN;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", Operator::add),
    MINUS("-", Operator::sub),
    DIVIDE("/", Operator::divide),
    MULTIPLE("*", Operator::multiple);

    private final String sign;
    private final BiFunction<Integer, Integer, Integer> operate;
    private final static int ZERO_NUMBER = 0;

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

    public int operate(final int number, final int operand) {
        return this.operate.apply(number, operand);
    }

    public static void divideZeroValidation(int operand) {
        if (operand == ZERO_NUMBER) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DIVIDE);
        }
    }

    private static int add(final int number, final int operand) {
        return number + operand;
    }

    private static int sub(final int number, final int operand) {
        return number - operand;
    }

    private static int divide(final int number, final int operand) {
        divideZeroValidation(operand);
        return number / operand;
    }

    private static int multiple(final int number, final int operand) {
        return number * operand;
    }

}
