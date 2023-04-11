import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToPositiveIntegersParser implements StringParser<Integer> {

    private static final Pattern PATTERN_INCLUDING_CUSTOM_DELIMITER =
        Pattern.compile("//(.)\\n(.*)");

    private static final String DEFAULT_DELIMITERS = ",|:";

    @Override
    public Integer[] parse(String originalInput) {
        String[] strParts = split(originalInput);

        return convertToNumbs(strParts);
    }

    private String[] split(String originalInput) {
        String delimiter = findDelimiter(originalInput);
        String expressionWithoutPrefix = extractExpressionPart(originalInput);

        return expressionWithoutPrefix.split(delimiter);
    }

    private Integer[] convertToNumbs(String[] numbers) {
        return Arrays.stream(numbers)
            .map(this::convertToPositiveNumb)
            .toArray(Integer[]::new);
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

    private Integer convertToPositiveNumb(String str) {
        int numb = Integer.parseInt(str);

        if (numb < 0) {
            throw new RuntimeException(String.format("%d : 0 이상의 정수가 아닙니다", numb));
        }
        return numb;
    }
}
