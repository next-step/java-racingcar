package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {
    private static final Pattern PATTERN = Pattern.compile("^//(.)\\n(.*)$");
    private static final String DELIMITER = "[,:]";
    private static final int MATCHER_CUSTOM_DELIMITER = 1;
    private static final int MATCHER_TEXT = 2;

    public static int splitAndSum(String text) {
        if(text == null || text.isBlank()) {
            return 0;
        }

        Matcher matcher = PATTERN.matcher(text);
        if(matcher.find()) {
            return sum(toIntegerList(splitCustomDelimiter(
                    matcher.group(MATCHER_CUSTOM_DELIMITER),matcher.group(MATCHER_TEXT))));
        }

        return sum(toIntegerList(splitDelimiter(text)));
    }

    private static List<String> splitCustomDelimiter(String customDelimiter, String text) {
        return List.of(text.split(customDelimiter));
    }

    private static List<String> splitDelimiter(String text) {
        return List.of(text.split(DELIMITER));
    }

    private static List<Integer> toIntegerList(List<String> list) {
        return list.stream()
                .map(StringAddCalculator::stringToInteger)
                .collect(Collectors.toList());
    }

    private static Integer stringToInteger(String text) {
        try {
            int number = Integer.parseInt(text);
            if(number < 0) {
                throw new IllegalArgumentException("음수는 불가능 합니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("String to Integer 변환 에러 발생!");
        }
    }

    private static int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(integer->integer).sum();
    }
}
