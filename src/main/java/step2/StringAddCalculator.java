package step2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class StringAddCalculator {

    public static final List<String> DEFAULT_DELIMITER = List.of(",", ":");
    private static final int GROUP_INDEX_DELIMITER = 1;
    private static final int GROUP_INDEX_NUMBERS = 2;

    /**
     * 문자열 덧셈 계산기
     *
     * @param input 입력값
     * @return 계산 결과
     */
    public static int calculate(String input) {
        if (isNullOrBlack(input)) {
            return 0;
        }

        return sum(toInts(split(input)));
    }

    private static boolean isNullOrBlack(String input) {
        return input == null || input.isBlank();
    }

    private static List<String> split(String input) {
        Matcher customMatcher = CalculatorMatcher.getCustomMatcher(input);

        if (customMatcher.find()) {
            return splitWithCustomDelimiter(customMatcher);
        }
        return List.of(input.split(defaultDelimiterRegex()));
    }

    private static List<String> splitWithCustomDelimiter(Matcher customMatcher) {
        return Arrays.stream(customMatcher.group(GROUP_INDEX_NUMBERS)
                        .split(customMatcher.group(GROUP_INDEX_DELIMITER)))
                .collect(Collectors.toList());
    }

    public static String defaultDelimiterRegex() {
        return "[" + String.join("", DEFAULT_DELIMITER) + "]";
    }

    private static List<Integer> toInts(List<String> values) {
        return values.stream()
                .map(value -> toInt(value))
                .collect(Collectors.toList());
    }

    private static int toInt(String value) {
        int number = Integer.parseInt(value);
        checkNegativeNumber(number);
        return number;
    }

    private static void checkNegativeNumber(int number) {
        if (number < 0) {
            throw new RuntimeException(String.format("음수(%s)는 사용할 수 없습니다.", number));
        }
    }

    private static int sum(List<Integer> values) {
        return values.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
