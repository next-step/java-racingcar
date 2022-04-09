package calculator;

import java.util.Objects;

public class Positive {
    private static final int MIN_NUMBER = 0;
    private static final String NEGATIVE_NUMBER_NOT_ALLOW_MESSAGE = "음수 값은 허용되지 않습니다.";
    private static final String ONLY_NUMBER_VALUE_ALLOW_MESSAGE = "숫자 값만 허용됩니다.";

    private final int number;

    public Positive(String text) {
        checkInt(text);

        int number = toInt(text);
        checkNegative(number);

        this.number = number;
    }

    private void checkInt(String text) {
        try {
            toInt(text);
        } catch (NumberFormatException e) {
            throw new RuntimeException(ONLY_NUMBER_VALUE_ALLOW_MESSAGE);
        }
    }

    private int toInt(String text) {
        return Integer.parseInt(text);
    }

    private void checkNegative(int number) {
        if (number < MIN_NUMBER) {
            throw new RuntimeException(NEGATIVE_NUMBER_NOT_ALLOW_MESSAGE);
        }
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Positive positive = (Positive) o;
        return number == positive.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
