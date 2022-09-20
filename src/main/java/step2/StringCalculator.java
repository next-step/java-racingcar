package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    // "1:2:3:4,5"
    private static final Pattern PATTERN = Pattern.compile(("//(.)\n(.*)"));
    private static final String DEFAULT_SEPARATOR = ":|,";
    private final UserInput userInput;

    public StringCalculator(UserInput userInput) {
        this.userInput = userInput;
    }

    public int calculate() {
        String separator = extractSeparator();
        String expression = extractExpression();
        return Arrays.stream(expression.split(separator))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    @SuppressWarnings("magicNumber")
    private String extractSeparator() {
        Matcher matcher = PATTERN.matcher(userInput.value());
        if (matcher.find()) {
            return matcher.group(1);
        }
        return DEFAULT_SEPARATOR;
    }

    private String extractExpression() {
        Matcher matcher = PATTERN.matcher(userInput.value());
        if (matcher.find()) {
            return matcher.group(2);
        }
        return userInput.value();
    }
}
