package calculator;

public class InputValidator {
    public static void isNullOrEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("해당 값은 null이거나 빈 공백이 올 수 없습니다. input = " + input);
        }
    }
}
