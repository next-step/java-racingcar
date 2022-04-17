package calculator;

import constant.StringCalculatorDelimiter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplit {
    private static final int CUSTOM_DELIMITER = 1;
    private static final int TEXT = 2;
    public static Matcher getCustomDelimiterMatcher(String text) {
        return Pattern.compile(StringCalculatorDelimiter.CUSTOM_DELIMITER_REGEXP).matcher(text);
    }

    public static String[] split(String text) {
        Matcher matcher = getCustomDelimiterMatcher(text);
        if (matcher.find()) {
            return matcher.group(TEXT).split(matcher.group(CUSTOM_DELIMITER));
        }
        return text.split(StringCalculatorDelimiter.DEFAULT_DELIMITER);
    }

}
