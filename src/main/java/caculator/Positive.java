package caculator;

import java.util.Objects;

public record Positive(int value) {

    public Positive {
        validate(value);
    }

    private static void validate(int value) {
        if (isNegative(value)) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + value);
        }
    }

    private static boolean isNegative(int number) {
        return number < 0;
    }

    public static Positive from(String text) {
        Objects.requireNonNull(text, "값은 null일 수 없습니다.");
        validateNotBlank(text);

        return new Positive(parseToInt(text));
    }

    private static void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("값은 비어있거나 공백일 수 없습니다.");
        }
    }

    private static int parseToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 아닙니다: " + value);
        }
    }
}
