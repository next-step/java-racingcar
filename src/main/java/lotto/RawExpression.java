package lotto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RawExpression {

    private String customDelimiter;
    private String expression;
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final Integer MATCH_GROUP_DELIMITER = 1;
    private static final Integer MATCH_GROUP_EXPRESSION = 2;

    public RawExpression(String rawExpression) {
        if (rawExpression == null || rawExpression.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RAW_EXPRESSION);
        }
        this.expression = rawExpression;
        Matcher matcher = Pattern
                .compile(CUSTOM_DELIMITER_REGEX)
                .matcher(rawExpression);
        if (matcher.find()) {
            this.customDelimiter = matcher.group(MATCH_GROUP_DELIMITER);
            this.expression = matcher.group(MATCH_GROUP_EXPRESSION);
        }
    }

    public String refineCustomDelimiter() {
        return customDelimiter;
    }

    public String refineRawExpression() {
        return expression;
    }
}
