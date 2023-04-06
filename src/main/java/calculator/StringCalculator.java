package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringCalculator {

    private static final int DEFAULT_VALUE = 0;

    private StringCalculator() {
        throw new IllegalCallerException("객체 생성이 불필요한 객체입니다.");
    }

    private static final String DEFAULT_SPLIT_REGEX = "[,:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\n";

    public static int calculate(String text) {
        if (isEmpty(text)) {
            return DEFAULT_VALUE;
        }
        String delimiter = extractCustomDelimiterOrDefault(text);
        text = removeCustomDelimiter(text, delimiter);
        validateStrangeValue(text, delimiter);
        String[] splitTexts = getSplitTexts(text, delimiter);
        return calculate(splitTexts);
    }

    private static boolean isEmpty(String text) {
        if (Objects.isNull(text)) {
            return true;
        }
        return text.isEmpty();
    }

    private static void validateStrangeValue(String text, String delimiter) {
        String regex = String.format("[^0-9%s]", delimiter);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            throw new RuntimeException("유효하지 않은 문자열이 포함되어 있습니다.");
        }
    }

    private static String extractCustomDelimiterOrDefault(String text) {
        if (!existCustomDelimiter(text)) {
            return DEFAULT_SPLIT_REGEX;
        }
        return text.substring(text.indexOf(CUSTOM_DELIMITER_PREFIX) + CUSTOM_DELIMITER_PREFIX.length(),
                              text.indexOf(CUSTOM_DELIMITER_SUFFIX));
    }

    private static boolean existCustomDelimiter(String text) {
        return text.startsWith(CUSTOM_DELIMITER_PREFIX) && text.contains(CUSTOM_DELIMITER_SUFFIX);
    }

    private static String removeCustomDelimiter(String text, String delimiter) {
        if (DEFAULT_SPLIT_REGEX.equals(delimiter)) {
            return text;
        }
        return text.split(CUSTOM_DELIMITER_SUFFIX)[1];
    }

    private static String[] getSplitTexts(String text, String delimiter) {
        return text.split(delimiter);
    }

    private static int calculate(String[] splitTexts) {
        int result = 0;
        for (String splitText : splitTexts) {
            int parsedValue = Integer.parseInt(splitText);
            if (parsedValue < 0) {
                throw new RuntimeException("음수는 연산에 해당되지 않습니다.");
            }
            result += parsedValue;
        }
        return result;
    }
}
