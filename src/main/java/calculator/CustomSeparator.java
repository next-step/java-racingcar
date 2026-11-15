package calculator;

import java.util.regex.Pattern;

public class CustomSeparator {
    private final String value;

    public CustomSeparator(String value) {
        if (value.isEmpty()) {
            throw new RuntimeException("custom separator is empty.");
        }
        if (value.length() > 1) {
            throw new RuntimeException("custom separator must be a single character.");
        }
        if (Character.isDigit(value.charAt(0))) {
            throw new RuntimeException("custom separator can not be a number.");
        }
        if (value.equals("-")) {
            throw new RuntimeException("custom separator can not be '-'.");
        }
        this.value = value;
    }

    public String toRegex() {
        return Pattern.quote(value);
    }
}
