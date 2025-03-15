package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String DEFAULT_DELIMITERS_REGEX = "[,:]";

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }
        if (hasCustomDelimiter(text)) {
            return sum(text.split(DEFAULT_DELIMITERS_REGEX));
        }
        return parseAndSumWithCustomDelimiter(text);
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static Integer parseAndSumWithCustomDelimiter(String text) {
        Matcher matcher = getCustomDelimeterAndNumbers(text);
        if (matcher.find()) {
            int delimiterGroupIndex = 1;
            int stringNumbersIndex = 2;
            String customDelimiter = matcher.group(delimiterGroupIndex);
            String[] stringNumbers = matcher.group(stringNumbersIndex).split(customDelimiter);
            return sum(stringNumbers);
        }
        throw new RuntimeException("입력을 확인해주세요.");
    }

    private static Matcher getCustomDelimeterAndNumbers(String text) {
        return CUSTOM_DELIMITER_PATTERN.matcher(text);
    }

    private static boolean hasCustomDelimiter(String text) {
        return !text.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private static int sum(String[] stringNumbers) {
        int sum = 0;
        for (String stringNumber : stringNumbers) {
            int number = parseNumber(stringNumber);
            sum += number;
        }
        return sum;

    }

    private static int parseNumber(String stringNumber) {
        int number = Integer.parseInt(stringNumber);
        if (number < 0) {
            throw new RuntimeException("음수는 불가능합니다.");
        }
        return number;
    }
}
