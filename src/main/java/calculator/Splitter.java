package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    public String[] split(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(text);
        if (hasCustomDelimiter(matcher)) {
            String nextText = matcher.group(2);
            String customDelimiter = matcher.group(1);
            return nextText.split(customDelimiter);
        }
        return text.split(DEFAULT_DELIMITER_REGEX);
    }

    private boolean hasCustomDelimiter(Matcher matcher) {
        return matcher.find();
    }

}
