package caculator;

import java.util.Objects;

public record Token(String value) {

    public Token {
        validate(value);
    }

    private static void validate(String input) {
        Objects.requireNonNull(input, "값은 null일 수 없습니다.");
        validateNotBlank(input);
        validateNumeric(input);
    }

    private static void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("값은 비어있거나 공백일 수 없습니다.");
        }
    }

    private static void validateNumeric(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 아닙니다: " + value);
        }
    }

    public int toPositive() {
        int number = Integer.parseInt(value);
        if (isNegative(number)) {
            throw new RuntimeException("음수는 입력할 수 없습니다: " + number);
        }
        return number;
    }

    private boolean isNegative(int number) {
        return number < 0;
    }
}
