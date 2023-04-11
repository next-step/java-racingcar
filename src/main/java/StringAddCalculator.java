import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern PATTERN_INCLUDING_CUSTOM_DELIMITER =
        Pattern.compile("//(.)\\n(.*)");

    private static final String DEFAULT_DELIMITERS = ",|:";

    private final IntBinaryOperator supportedOperation;

    public StringAddCalculator(IntBinaryOperator supportedOperation) {
        this.supportedOperation = supportedOperation;
    }

    public int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }

        int[] numbs = convertToNumbs(split(input));

        return calc(numbs);
    }

    private boolean isBlank(String input) {
        if (input == null || input.isBlank()) {
            return true;
        }
        return false;
    }

    private String[] split(String originalInput) {
        String delimiter = findDelimiter(originalInput);

        String expressionWithoutPrefix = extractExpressionPart(originalInput);

        return expressionWithoutPrefix.split(delimiter);
    }

    private int[] convertToNumbs(String[] numbers) {
        return Arrays.stream(numbers)
            .mapToInt(this::convertToNumb)
            .toArray();
    }

    private int calc(int[] numbs) {
        return Arrays.stream(numbs)
            .reduce(0, supportedOperation);
    }

    private String findDelimiter(String expression) {
        Matcher matcher = PATTERN_INCLUDING_CUSTOM_DELIMITER.matcher(expression);

        if (matcher.find()) {
            return matcher.group(1);
        }

        return DEFAULT_DELIMITERS;
    }

    private String extractExpressionPart(String originalExpression) {
        Matcher matcher = PATTERN_INCLUDING_CUSTOM_DELIMITER.matcher(originalExpression);

        if (matcher.find()) {
            return matcher.group(2);
        }

        return originalExpression;
    }

    private int convertToNumb(String str) {
        checkValidNumber(str);

        return Integer.parseInt(str);
    }

    private void checkValidNumber(String number) {
        for (int idx = 0; idx < number.length(); idx++) {
            checkIsNumber(number.charAt(idx));
        }
    }

    private void checkIsNumber(char curChar) {
        if (curChar < '0' || curChar > '9') {
            throw new RuntimeException(String.format("%c : 0 이상의 정수가 아닙니다", curChar));
        }
    }
}
