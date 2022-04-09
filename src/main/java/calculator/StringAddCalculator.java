package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.)\\n(.*)$");
    private static final String COMMA_OR_COLON_DELIMITER = "[,:]";
    private static final int NULL_AND_BLANK_VALUE = 0;
    private static final int FOR_CHECK_NEGATIVE_NUMBER = 0;
    private static final int MATCHER_CUSTOM_DELIMITER = 1;
    private static final int MATCHER_TEXT = 2;

    public static int splitAndSum(String text) {
        if(checkNullAndBlank(text)) {
            return NULL_AND_BLANK_VALUE;
        }

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if(matcher.find()) {
            String matcherGroupDelimiter = matcher.group(MATCHER_CUSTOM_DELIMITER);
            return sum(toIntegerList(splitDelimiter(matcherGroupDelimiter, matcher.group(MATCHER_TEXT))));
        }

        return sum(toIntegerList(splitDelimiter(COMMA_OR_COLON_DELIMITER,text)));
    }

    private static boolean checkNullAndBlank(String text) {
        return text == null || text.isBlank();
    }

    private static List<String> splitDelimiter(String customDelimiter, String text) {
        return List.of(text.split(customDelimiter));
    }

    private static List<Integer> toIntegerList(List<String> list) {
        return list.stream()
                .map(StringAddCalculator::toInteger)
                .collect(Collectors.toList());
    }

    private static Integer toInteger(String text) {
        try {
            int number = Integer.parseInt(text);
            if(number < FOR_CHECK_NEGATIVE_NUMBER) {
                throw new IllegalArgumentException("음수는 불가능 합니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("String to Integer 변환 에러 발생!");
        }
    }

    private static int sum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(integer->integer)
                .sum();
    }
}
