package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final String MATCH_CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    public static final String DEFAULT_DELIMITER_REGEX = ",|:";

    private record ParsedInput(String delimiter, String expression) {}

    public static int calculate(String expression) {
        if (isValidExpression(expression)) return 0;

        ParsedInput parsedInput = getParsedInput(expression);
        String[] stringArray = parsedInput.expression.split(parsedInput.delimiter);

        return sum(getIntArray(stringArray));
    }

    private static boolean isValidExpression(String expression) {
        return expression == null || expression.isEmpty();
    }

    private static boolean isValidCustomDelimiter(String delimiter) {
        return !delimiter.matches("-?\\d+(\\.\\d+)?");
    }

    private static ParsedInput getParsedInput(String expression) {
        Matcher m = Pattern.compile(MATCH_CUSTOM_DELIMITER_REGEX).matcher(expression);
        if (m.find() && isValidCustomDelimiter(m.group(1))) {
            return new ParsedInput(DEFAULT_DELIMITER_REGEX + "|" + m.group(1), m.group(2));
        }

        return new ParsedInput(DEFAULT_DELIMITER_REGEX, expression);
    }

    private static int[] getIntArray(String[] stringArray) {
        int[] result = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            result[i] = getPositiveNumber(stringArray[i]);
        }
        return result;
    }

    private static int getPositiveNumber(String strNumber) {
        int number = Integer.parseInt(strNumber);
        if (number < 0) {
            throw new RuntimeException("Negative number " + strNumber);
        }
        return number;
    }

    private static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
