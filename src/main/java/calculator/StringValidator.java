package calculator;

public class StringValidator {

    public void validateNotEmpty(String input) {
        if (input == null || input.trim().length() == 0) {
            throw new IllegalArgumentException("empty string");
        }
    }
}
