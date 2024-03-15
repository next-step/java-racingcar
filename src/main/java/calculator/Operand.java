package calculator;

import static java.math.BigInteger.ZERO;
import static java.text.MessageFormat.format;

import java.math.BigInteger;

public class Operand {

    private static final String INVALID_NUMBER_FORMAT_MESSAGE = "수식을 이루는 피연산자는 반드시 숫자이어야 합니다. [입력값 : {0}]";
    private static final String NEGATIVE_VALUE_MESSAGE = "피연산자는 반드시 0 이상이어야 합니다. [입력값 : {0}]";

    private final BigInteger value;

    private Operand(final BigInteger value) {
        validateValueIsPositiveOrZero(value);

        this.value = value;
    }

    private void validateValueIsPositiveOrZero(final BigInteger value) {
        if (isNegative(value)) {
            throw new RuntimeException(format(NEGATIVE_VALUE_MESSAGE, value));
        }
    }

    private boolean isNegative(final BigInteger value) {
        return value.compareTo(ZERO) < 0;
    }

    public BigInteger value() {
        return this.value;
    }

    public static Operand from(final String token) {
        try {
            return new Operand(new BigInteger(token));
        } catch (NumberFormatException e) {
            throw new RuntimeException(format(INVALID_NUMBER_FORMAT_MESSAGE, token));
        }
    }
}
