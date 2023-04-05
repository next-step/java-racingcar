package calculator;

import java.util.Objects;

public class StringCalculator {

    private static final int DEFAULT_VALUE = 0;
    private static final String DEFAULT_SPLIT_REGEX = "[,:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\n";

    public int calculate(String text) {
        if (isEmpty(text)) {
            return DEFAULT_VALUE;
        }
        String delimiter = extractCustomDelimiterOrDefault(text);
        text = removeCustomDelimiter(text, delimiter);
        String[] splitTexts = getSplitTexts(text, delimiter);
        return calculate(splitTexts);
    }

    private boolean isEmpty(String text) {
        if (Objects.isNull(text)) {
            return true;
        }
        return text.isEmpty();
    }

    private String extractCustomDelimiterOrDefault(String text) {
        if (!existCustomDelimiter(text)) {
            return DEFAULT_SPLIT_REGEX;
        }
        return text.substring(text.indexOf(CUSTOM_DELIMITER_PREFIX) + CUSTOM_DELIMITER_PREFIX.length(),
                              text.indexOf(CUSTOM_DELIMITER_SUFFIX));
    }

    private boolean existCustomDelimiter(String text) {
        return text.startsWith(CUSTOM_DELIMITER_PREFIX) && text.contains(CUSTOM_DELIMITER_SUFFIX);
    }

    private String removeCustomDelimiter(String text, String delimiter) {
        if (DEFAULT_SPLIT_REGEX.equals(delimiter)) {
            return text;
        }
        return text.split(CUSTOM_DELIMITER_SUFFIX)[1];
    }

    private String[] getSplitTexts(String text, String delimiter) {
        return text.split(delimiter);
    }

    private int calculate(String[] splitTexts) {
        int result = 0;
        for (String splitText : splitTexts) {
            int parsedValue = Integer.parseInt(splitText);
            result += parsedValue;
        }
        return result;
    }
}
