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

    boolean isCustom() {
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

    public int[] toInts() {
        Positive[] positives = toPositives(splitExpression());
        int[] ints = new int[positives.length];

        for (int i = 0; i < positives.length; i++) {
            ints[i] = positives[i].getNumber();
        }

        return ints;
    }

    private Positive[] toPositives(String[] numbers) {
        Positive[] positives = new Positive[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            int number = Integer.parseInt(numbers[i]);
            positives[i] = new Positive(number);
        }

        return positives;
    }

    private String[] splitExpression() {
        return expression.split(STANDARD_DELIMITER_PATTERN);
    }
}
