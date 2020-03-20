package calculator;

public class InputValidator {
    public void nullCheck(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void operatorCheck(String input) {
        if (!("+".equals(input)
                || "-".equals(input)
                || "*".equals(input)
                || "/".equals(input))) {
            throw new IllegalArgumentException();
        }
    }
}
