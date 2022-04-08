package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    public static final String COMMON_DELIMITER = "[,:]";
    public static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    public static final Pattern PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        Numbers numbers = convertToNumbers(splitText(input));
        return numbers.sum();
    }

    private Numbers convertToNumbers(String[] splitText) {
        List<PositiveNumber> collect = Arrays.stream(splitText)
                .map(PositiveNumber::createPositiveNumber)
                .collect(Collectors.toList());
        return new Numbers(collect);
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
