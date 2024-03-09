package util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String DEFAULT_DELIMITER_FORMAT_REGEX = String.format("^-?\\d+([%s]-?\\d+)*$", DEFAULT_DELIMITER);
    private static final String CUSTOM_DELIMITER_FORMAT_REGEX = "//(.)\n(.*)";

    public static int add(String input) {
        if (isBlank(input)) {
            return 0;
        }
        if (!isValidFormat(input)) {
            return 0;
        }

        List<Integer> list = split(input);

        return add(list);
    }

    private static int add(List<Integer> list) {
        return list.stream()
                .peek(value -> {
                    if (value < 0) {
                        throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                    }
                })
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

    private static boolean isValidFormat(String input) {
        return Pattern.matches(DEFAULT_DELIMITER_FORMAT_REGEX, input) || Pattern.matches(CUSTOM_DELIMITER_FORMAT_REGEX, input);
    }

    private static List<Integer> split(String input) {
        return input.matches(DEFAULT_DELIMITER_FORMAT_REGEX) ? splitByDefaultDelimiter(input) : splitByCustomDelimiter(input);
    }

    private static List<Integer> splitByDefaultDelimiter(String input) {
        return Arrays.stream(input.split(DEFAULT_DELIMITER))
                .map(Integer::parseInt)
                .collect(toList());
    }

    private static List<Integer> splitByCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_FORMAT_REGEX).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] values = matcher.group(2).split(customDelimiter);
            return Arrays.stream(values)
                    .map(Integer::parseInt)
                    .collect(toList());
        }
        return Collections.emptyList();
    }
}
