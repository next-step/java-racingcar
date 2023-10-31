package stringaddcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private StringAddCalculator() {
    }

    public static final String BASE_SPLIT_REGEX = "[,:]";
    public static final String CUSTOM_SPLIT_REGEX = "//(.)\n(.*)";

    public static int splitAndSum(String inputString) {
        if (validateInputString(inputString) instanceof Integer) {
            return (int) validateInputString(inputString);
        }

        String[] splitStrings = splitInputString(inputString);
        return sumStringArray(splitStrings);
    }

    private static Object validateInputString(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return 0;
        }

        if (inputString.length() == 1) {
            return parseInt(inputString);
        }

        return inputString;
    }

    private static String[] splitInputString(String inputString) {
        Matcher matcher = Pattern.compile(CUSTOM_SPLIT_REGEX).matcher(inputString);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return inputString.split(BASE_SPLIT_REGEX);
    }

    private static int sumStringArray(String[] splitStrings) {
        return Arrays.stream(splitStrings)
                .mapToInt(StringAddCalculator::parseInt)
                .sum();
    }

    private static int parseInt(String inputString) {
        try {
            return Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
