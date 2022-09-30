import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    final static String COMMA_OR_COLON = ",|:";
    final static String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    public static int splitAndSum(String text) {
        if (isNullOrBlank(text)) {
            return 0;
        }

        List<Integer> numbers = toInts(toTokens(text));
        checkNegative(numbers);
        return sum(numbers);
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isBlank();
    }

    private static List<String> toTokens(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return List.of(matcher.group(2).split(customDelimiter));
        }

        return List.of(text.split(COMMA_OR_COLON));
    }

    private static List<Integer> toInts(List<String> tokens) {
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            numbers.add(Integer.parseInt(token));
        }
        return numbers;
    }
    private static void checkNegative(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 0) {
                throw new RuntimeException("음수는 포함될 수 없습니다.");
            }
        }
    }

    private static int sum(List<Integer> numbers) {
        int result = 0;
        for (Integer number : numbers) {
            result += number;
        }
        return result;
    }
}
