package step2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class Input {
    String tokens;

    public Input(String tokens) {
        this.tokens = tokens;
    }

    public boolean isNotValidInput() {
        if (this.tokens == null || this.tokens.isBlank()) {
            return true;
        }
        isNegativeNumber();
        return false;
    }

    private void isNegativeNumber() {
        Matcher negativeMatcher = CalculatorMatcher.getNegativeMatcher(this.tokens);

        if (negativeMatcher.matches()) {
            throw new RuntimeException(String.format("Negative numbers are not allowed: %s", this.tokens));
        }
    }

    public Boolean hasCustomDelimiter() {
        return CalculatorMatcher.getCustomMatcher(this.tokens).matches();
    }

    public List<String> parseWithCustomDelimiterOrNull() {
        Matcher customMatcher = CalculatorMatcher.getCustomMatcher(this.tokens);

        if (customMatcher.find()) {
            final String delimiter = customMatcher.group(1);
            return Arrays.stream(customMatcher.group(2).split(delimiter))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public Boolean hasDefaultDelimiter() {
        return this.tokens.contains(",") || this.tokens.contains(":");
    }

    public Integer parseToInt() {
        return Integer.parseInt(this.tokens);
    }

    public List<String> splitWithDefaultRegex(String defaultDelimiterRegex) {
        return Arrays.stream(this.tokens.split(defaultDelimiterRegex))
                .collect(Collectors.toList());
    }
}
