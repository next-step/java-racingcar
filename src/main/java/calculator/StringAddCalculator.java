package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEXP = "//(.)\n(.*)";
    private static final int DEFAULT_RESULT = 0;

    static int splitAndSum(String text) {
        if (isInvalid(text)) {
            return DEFAULT_RESULT;
        }

        return sum(convertToInts(split(text)));
    }

    private static boolean isInvalid(String text) {
        return text == null || text.isEmpty();
    }

    private static int sum(int[] numbers) {
        return Arrays.stream(numbers).reduce(0, Integer::sum);
    }

    private static int[] convertToInts(String[] texts) {
        return Arrays.stream(texts).mapToInt(Integer::parseInt).filter(value -> {
            if (value < 0) {
                throw new IllegalArgumentException();
            }
            return true;
        }).toArray();
    }

    private static String[] split(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEXP).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return text.split(DELIMITER);
    }
}

