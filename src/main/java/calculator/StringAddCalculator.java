package calculator;

import calculator.util.StringUtils;
import error.CustomError;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_PATTERN = ",|:";

    public static int splitAndSum(String input) {
        if (StringUtils.isBlank(input)) {
            return 0;
        }
        String[] inputs = splitByDelimiter(input);
        return splitAndSum(inputs);
    }

    private static int splitAndSum(String[] inputs) {
        return Arrays.stream(inputs)
                     .map(StringAddCalculator::toInt)
                     .reduce(Integer::sum)
                     .orElse(0);
    }

    private static int toInt(String input) {
        int number = Integer.parseInt(input);
        if (number < 0) {
            throw new RuntimeException(CustomError.NEGATIVE_NUMBER_ERROR.getErrorContent());
        }
        return number;
    }

    private static String[] splitByDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String inputToSplit = matcher.group(2);
            return inputToSplit.split(customDelimiter);
        }
        return input.split(DEFAULT_PATTERN);
    }
}
