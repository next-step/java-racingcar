package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final String DELIMITER_REGEX = "[,:]";
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int TEXT_INDEX = 2;

    public int splitAndSum(String text) {
        return sum(toIntArray(split(text)));
    }

    private int sum(int[] array) {
        return Arrays.stream(array)
                .sum();
    }

    private int[] toIntArray(String[] text) {
        return Arrays.stream(text)
                .mapToInt(Integer::parseInt)
                .peek(this::validate)
                .toArray();
    }

    private void validate(int number) {
        if (number < 0) {
            throw new RuntimeException("음수가 존재할 수 없습니다. number: " + number);
        }
    }

    private String[] split(String text) {
        if (isBlank(text)) {
            return new String[]{"0"};
        }

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);

        if (isCustomDelimiter(matcher)) {
            final var delimiter = matcher.group(CUSTOM_DELIMITER_INDEX);

            return matcher.group(TEXT_INDEX).split(delimiter);
        }

        return text.split(DELIMITER_REGEX);
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private boolean isCustomDelimiter(Matcher matcher) {
        return matcher.find();
    }

}
