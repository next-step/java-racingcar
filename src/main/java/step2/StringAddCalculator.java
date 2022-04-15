package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private StringAddCalculator() {
        throw new RuntimeException("유틸성 클래스 인스턴스화 방지");
    }

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(("//(.)\n(.*)"));
    private static final int VALUE_FOR_NULL_OR_EMPTY_TEXT = 0;

    public static int splitAndSum(String text) {

        if (text == null || text.isBlank()) {
            return VALUE_FOR_NULL_OR_EMPTY_TEXT;
        }

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        return sum(split(matcher, text));
    }

    private static String[] split(Matcher matcher, String text) {
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return text.split(DEFAULT_DELIMITER);
    }

    private static int sum(String[] values) {
        Positive result = new Positive(0);
        for (String value : values) {
            result = result.add(new Positive(value));
        }
        return result.toResult();
    }
}
