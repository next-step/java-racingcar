package calculator;

import static java.text.MessageFormat.*;

public class Operand {

    private static final String INVALID_NUMBER_FORMAT_MESSAGE = "수식을 이루는 피연산자는 반드시 숫자이어야 합니다. [입력값 : {0}]";
    private static final String NEGATIVE_VALUE_MESSAGE = "피연산자는 반드시 0 이상이어야 합니다. [입력값 : {0}]";

    private final int value;

    private Operand(final int value) {
        validateValueIsPositiveOrZero(value);

        this.value = value;
    }

    public static Operand from(final String token) {
        try {
            return new Operand(Integer.parseInt(token));
        } catch (NumberFormatException e) {
            throw new RuntimeException(format(INVALID_NUMBER_FORMAT_MESSAGE, token));
        }
    }

    public int value() {
        return this.value;
    }

    private void validateValueIsPositiveOrZero(final int value) {
        if (value < 0) {
            throw new RuntimeException(format(NEGATIVE_VALUE_MESSAGE, value));
        }
    }
}
