package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITER = ",|:";

    public Number splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return new Number(0);
        }

        Numbers numbers = Numbers.create(splitNumber(input));
        return numbers.sum();
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private String[] splitNumber(String string) {
        Matcher matcher = CUSTOM_PATTERN.matcher(string);
        if (matcher.matches()) {
            return matcher.group(2).split(matcher.group(1));
        }
        return string.split(DEFAULT_DELIMITER);
    }
}
