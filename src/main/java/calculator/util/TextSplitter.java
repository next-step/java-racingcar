package calculator.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TextSplitter {

    private static final String NULL_OR_BLANK_NUMBER = "0";
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    private TextSplitter() {
    }

    public static List<String> split(final String text) {
        if (StringUtils.hasNotText(text)) {
            return List.of(NULL_OR_BLANK_NUMBER);
        }

        return List.of(splitNormal(text));
    }

    private static String[] splitNormal(final String text) {
        final Matcher delimiterMatcher = CUSTOM_PATTERN.matcher(text);

        if (delimiterMatcher.find()) {
            return delimiterMatcher.group(2)
                                   .split(createCustomDelimiter(delimiterMatcher));
        }

        return text.split(DEFAULT_DELIMITER);
    }

    private static String createCustomDelimiter(final Matcher delimiterMatcher) {
        return DEFAULT_DELIMITER + "|" + delimiterMatcher.group(1);
    }
}
