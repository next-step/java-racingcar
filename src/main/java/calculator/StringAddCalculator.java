package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringAddCalculator {
    private static final String COMMA_OR_COLON = "[,:]";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final int PATTERN_MATCHER_GROUP_CUSTOM_DELIMITER_INDEX = 1;
    private static final int PATTERN_MATCHER_GROUP_TEXT_ARRAY_INDEX = 2;
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }
        return sum(toInt(splitString(text)));
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isBlank();
    }

    private static String[] splitString(String text) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(PATTERN_MATCHER_GROUP_CUSTOM_DELIMITER_INDEX);
            return matcher.group(PATTERN_MATCHER_GROUP_TEXT_ARRAY_INDEX).split(customDelimiter);
        }
        return text.split(COMMA_OR_COLON);
    }

    private static int[] toInt(String[] splitTextArray) {
        return Stream.of(splitTextArray).mapToInt(StringAddCalculator::parsePositiveIntOrThrow).toArray();
    }

    private static int parsePositiveIntOrThrow(String splitText) {
        int intNum = Integer.parseInt(splitText);
        if (intNum < 0) {
            StringAddCalculator.occurExceptionWithMessage();
        }
        return intNum;
    }

    public static void occurExceptionWithMessage() throws RuntimeException {
        throw new PositiveException("Positive Exception is occurred");
    }

    private static int sum(int[] ints) {
        return Arrays.stream(ints).sum();
    }
}
