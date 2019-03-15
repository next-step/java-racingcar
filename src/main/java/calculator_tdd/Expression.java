package calculator_tdd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String STANDARD_DELIMITER_PATTERN = COMMA + "|" + COLON;
    private static final Pattern CUSTOM_EXPRESSION_PATTERN = Pattern.compile("//(.)\n(.*)");

    private final String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    public boolean isCustom() {
        return CUSTOM_EXPRESSION_PATTERN.matcher(this.expression).matches();
    }

    Expression toStandard() {
        if (!isCustom()) {
            return this;
        }

        String standardExpression = convertInternalExpression();

        return new Expression(standardExpression);
    }

    private String convertInternalExpression() {
        Matcher matcher = CUSTOM_EXPRESSION_PATTERN.matcher(this.expression);
        matcher.find();

        String customDelimiter = matcher.group(1);
        String customExpression = matcher.group(2);

        return customExpression.replaceAll(customDelimiter, COMMA);
    }

    public int[] toNumbers() {
        return toInts(splitExpression());
    }

    private int[] toInts(String[] numbers) {
        int[] ints = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            ints[i] = Integer.parseInt(numbers[i]);
        }

        return ints;
    }

    private String[] splitExpression() {
        return expression.split(STANDARD_DELIMITER_PATTERN);
    }
}
