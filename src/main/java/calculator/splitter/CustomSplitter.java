package calculator.splitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CustomSplitter {

    public static final String DEFAULT_DELIMITER_REGEX = ",|:";
    public static final String CUSTOM_DELIMITER_REGEX = "//(.*)\n(.*)";
    public static final int DELIMITER_GROUP = 1;
    public static final int TARGET_GROUP = 2;
    public static final List<String> FORBIDDEN_DELIMITERS = List.of("$", "^", "*", "(", ")", "{", "}", "[", "]", "+", "?", "|", ".");

    private final String input;
    private final Matcher matcher;

    protected CustomSplitter(String input) {
        this.input = input;
        this.matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
    }

    List<String> split() {
        boolean hasCustomDelimiterRegex = matcher.matches();
        String target = hasCustomDelimiterRegex ? matcher.group(TARGET_GROUP) : input;

        String delimiter = hasCustomDelimiterRegex ? matcher.group(DELIMITER_GROUP) : DEFAULT_DELIMITER_REGEX;
        for (String forbiddenDelimiter : FORBIDDEN_DELIMITERS) {
            validateDelimiter(delimiter, forbiddenDelimiter);
        }

        List<String> split = Arrays.asList(target.split(delimiter));

        return filterEmptyString(split);
    }

    private void validateDelimiter(final String subject, final String forbiddenDelimiter) {
        if (subject.contains(forbiddenDelimiter)) {
            throw new RuntimeException("사용할 수 없는 구분자입니다.");
        }
    }

    private static List<String> filterEmptyString(final List<String> split) {
        List<String> result = new ArrayList<>();

        for (String number : split) {
            if (!number.isEmpty()) {
                result.add(number);
            }
        }

        return result;
    }
}
