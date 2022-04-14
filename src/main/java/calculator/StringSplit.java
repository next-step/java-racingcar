package calculator;

import constant.StringCalculatorDelimiter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplit {
    public static Matcher getCustomDelimiterMatcher(String text) {
        return Pattern.compile(StringCalculatorDelimiter.CUSTOM_DELIMITER_REGEXP).matcher(text);
    }

    public static String[] split(String text) {
        Matcher matcher = getCustomDelimiterMatcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return text.split(StringCalculatorDelimiter.DEFAULT_DELIMITER);
    }

}
