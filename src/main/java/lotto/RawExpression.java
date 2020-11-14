package lotto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RawExpression {

    private String customDelimiter;
    private String expression;
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public RawExpression(String rawExpression) {
        this.expression = rawExpression;
        Matcher matcher = Pattern
                .compile(CUSTOM_DELIMITER_REGEX)
                .matcher(rawExpression);
        if (matcher.find()) {
            this.customDelimiter = matcher.group(1);
            this.expression = matcher.group(2);
        }
    }

    public String refineCustomDelimiter() {
        return customDelimiter;
    }

    public String refineRawExpression() {
        return expression;
    }
}
