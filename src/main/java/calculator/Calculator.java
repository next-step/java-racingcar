package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final Pattern DELIMITER_PATTERN = Pattern.compile("//(.)\\n(.*)");
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final int DEFAULT_RETURN_VALUE = 0;

    public static int sumText(String text) {
        if (isBlank(text)) return DEFAULT_RETURN_VALUE;
        return sum(toInt(split(text)));
    }

    private static boolean isBlank(String text) {
        return Objects.isNull(text) || text.isEmpty();
    }

    private static String[] split(String text) {
        return toSplitText(text).split(findDelimiter(text));
    }

    private static int[] toInt(String[] stringValues) {
        int valueLength = stringValues.length;
        int[] intValues = new int[valueLength];
        for (int i = 0; i < valueLength; i++) {
            intValues[i] = Integer.parseUnsignedInt(stringValues[i]);
        }
        return intValues;
    }

    private static String findDelimiter(String text) {
        String delimiter = DEFAULT_DELIMITER;
        Matcher matcher = findDelimiterMatcher(text);
        if (matcher.find()) delimiter = matcher.group(1);
        return delimiter;
    }

    private static String toSplitText(String text) {
        Matcher matcher = findDelimiterMatcher(text);
        if (matcher.find()) text = matcher.group(2);
        return text;
    }

    private static Matcher findDelimiterMatcher(String text) {
        return DELIMITER_PATTERN.matcher(text);
    }

    private static int sum(int[] intValues) {
        int sum = DEFAULT_RETURN_VALUE;
        for (int value : intValues) {
            sum += value;
        }
        return sum;
    }
}
