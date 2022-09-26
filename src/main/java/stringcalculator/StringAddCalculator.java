package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITERS = ",|:";

    public static int splitAndAdd(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        return add(split(getValidInput(input), getDelimiter(input)));
    }

    private static int add(String[] stringNumberArray) {
        return Arrays.stream(stringNumberArray)
                     .mapToInt(StringAddCalculator::parseInt)
                     .sum();
    }

    private static int parseInt(String maybeNumberString) {
        try {
            int parsedValue = Integer.parseInt(maybeNumberString);

            if (parsedValue < 0) {
                throw new RuntimeException("0 또는 양수만 처리 가능합니다");
            }

            return parsedValue;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private static String[] split(String input, String delimiter) {
        return input.split(delimiter);
    }

    private static boolean hasCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        return matcher.find();
    }

    private static String getDelimiter(String input) {
        if (hasCustomDelimiter(input)) {
            Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
            if (matcher.find()) {
                return matcher.group(1);
            }
        }

        return DEFAULT_DELIMITERS;
    }

    private static String removeCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            return matcher.group(2);
        }

        return input;
    }

    private static String getValidInput(String input) {
        if (hasCustomDelimiter(input)) {
            return removeCustomDelimiter(input);
        }

        return input;
    }
}
