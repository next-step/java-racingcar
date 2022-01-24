package stringcalculator.domain;

import java.util.Arrays;
import java.util.function.ToIntBiFunction;

import static stringcalculator.common.ErrorMessage.ERROR_MESSAGE_DIVIDED_BY_ZERO;
import static stringcalculator.common.ErrorMessage.ERROR_MESSAGE_SIGN;

public enum Operator {
    PLUS("+", Operator::add),
    MINUS("-", Operator::sub),
    DIVIDE("/", Operator::divide),
    MULTIPLE("*", Operator::multiple);

    private String sign;
    private ToIntBiFunction<Integer, Integer> operate;

    Operator(final String sign, final ToIntBiFunction<Integer, Integer> operate) {
        this.sign = sign;
        this.operate = operate;
    }

    public static Operator from(final String inputSign) {
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
        if (operand == 0) {
            throw new ArithmeticException(ERROR_MESSAGE_DIVIDED_BY_ZERO);
        }
        return number / operand;
    }

    private static int multiple(final int number, final int operand) {
        return number * operand;
    }

    public int operate(final int number, final int operand) {
        return this.operate.applyAsInt(number, operand);
    }

}
