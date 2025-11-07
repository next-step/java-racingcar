package caculator;

import java.util.Objects;

public record PositiveOrZero(int value) {

    public PositiveOrZero {
        validateInvariant(value);
    }

    public PositiveOrZero(String text) {
        this(Integer.parseInt(text));
    }

    private static void validateInvariant(int value) {
        if (isNegative(value)) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + value);
        }
    }

    private static boolean isNegative(int number) {
        return number < 0;
    }
}
