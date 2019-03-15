package calculator_tdd;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdder {
    private static final Pattern CUSTUM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String STANDARD_DELIMITER_PATTERN = COMMA + "|" + COLON;

    public static int calculate(String expression) {
        if (checkCustomSeparator(expression)) {
            expression = changeCustomExpressionToStandard(expression);
        }

        String[] numbers = expression.split(STANDARD_DELIMITER_PATTERN);

        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static String changeCustomExpressionToStandard(String customExpression) {
        Matcher matcher = CUSTUM_DELIMITER_PATTERN.matcher(customExpression);
        matcher.find();

        String customDelimiter = matcher.group(1);
        String expression = matcher.group(2);

        return expression.replaceAll(customDelimiter, COMMA);
    }

    private static boolean checkCustomSeparator(String expression) {
        Matcher matcher = CUSTUM_DELIMITER_PATTERN.matcher(expression);
        return matcher.matches();
    }
}
