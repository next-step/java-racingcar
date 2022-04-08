package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final String COMMON_DELIMITER = "[,:]";
    public static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    public static final Pattern PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] splitText = splitText(input);
        PositiveNumbers numbers = PositiveNumber.convertToPositiveNumbers(splitText);
        return numbers.sum();
    }

    private String[] splitText(String input) {
        Matcher matcher = PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return input.split(COMMON_DELIMITER);
    }
}
