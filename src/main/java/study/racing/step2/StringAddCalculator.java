package study.racing.step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern INTEGER_PATTERN = Pattern.compile("^0|[-]?[0-9]*$");
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int calculate(String text) {
        if (isBlank(text)) {
            return 0;
        }

        if (isOnlyNumber(text)) {
            return Integer.parseInt(text);
        }

        String delimiter = extractDelimiter(text);

        Matcher customDelimiterMatcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (customDelimiterMatcher.find()) {
            text = customDelimiterMatcher.group(2);
        }

        return calculate(text, delimiter);
    }


    private static int calculate(String text, String delimiter) {
        return Arrays.stream(text.split(delimiter))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static String extractDelimiter(String text) {
        String delimiter = "";
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);

        if (m.find()) {
            delimiter = m.group(1);
        } else if (isSeparateNumbers(text, ",|:")) {
            delimiter = ",|:";
        }

        return delimiter;
    }

    private static boolean isSeparateNumbers(String text, String delimiter) {
        return Arrays.stream(text.split(delimiter))
                .allMatch(StringAddCalculator::validatePositiveNumber);
    }

    private static boolean validatePositiveNumber(String text) {
        Matcher m = INTEGER_PATTERN.matcher(text);
        if (m.matches()) {
            if (Integer.parseInt(m.group()) < 0) {
                throw new RuntimeException("음의 정수가 포함되어 있습니다.");
            } else {
                return true;
            }
        } else {
            throw new RuntimeException("숫자 이외의 값이 포함되어 있습니다.");
        }
    }

    private static boolean isOnlyNumber(String text) {
        try {
            return Integer.valueOf(text) instanceof Integer;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

}
