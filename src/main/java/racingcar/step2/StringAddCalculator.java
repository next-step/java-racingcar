package racingcar.step2;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String CUSTOM_DELIMITER_REGEX_PATTERN = "//(.)\n(.*)";
    public static final String DEFAULT_DELIMITER_REGEX_PATTERN = ",|:";

    public static final int EMPTY_INPUT_RESPONSE = 0;

    public static final int CUSTOM_DELIMITER_INDEX = 1;
    public static final int TARGET_INDEX = 2;

    public static int splitAndSum(String input) {
        if (isNullOrBlank(input)) {
            return EMPTY_INPUT_RESPONSE;
        }

        List<String> tokens = split(input);

        return sum(tokens);
    }

    private static boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }

    private static List<String> split(String input) {
        String target = input;
        String regexPattern = DEFAULT_DELIMITER_REGEX_PATTERN;

        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX_PATTERN).matcher(input);
        if (m.find()) {
            target = m.group(TARGET_INDEX);
            regexPattern += ("|" + m.group(CUSTOM_DELIMITER_INDEX));
        }

        return tokenizeTargetByRegexPattern(target, regexPattern);
    }

    private static List<String> tokenizeTargetByRegexPattern(String target, String regexPattern) {
        return List.of(
                target.split(regexPattern)
        );
    }

    private static int sum(List<String> tokens) {
        return tokens.stream()
                .mapToInt(StringAddCalculator::parsePositiveInt)
                .sum();
    }

    private static int parsePositiveInt(String input) {
        int number;

        try {
            number = Integer.parseInt(input);
            validateNegative(number);
        } catch (Exception e) {
            throw new RuntimeException("덧셈 요소를 변환하는도중 오류가 발생했습니다.", e);
        }

        return number;
    }

    private static void validateNegative(int number) {
        if (number < 0) {
            throw new RuntimeException("덧셈 요소에 음수를 사용할 수 없습니다.");
        }
    }
}
