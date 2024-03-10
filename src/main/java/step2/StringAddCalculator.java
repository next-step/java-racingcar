package step2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DELIMITER_PATTERN =  "[,:]";
    private static final int DEFAULT_VALUE = 0;
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int NUMBERS_GROUP = 2;

    private StringAddCalculator() {
    }

    public static int splitAndSum(String text) {

        if (isBlank(text)) {
            return DEFAULT_VALUE;
        }
        List<String> tokens = tokenize(text);
        return calculateSum(tokens);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static List<String> tokenize(String text) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            return splitUsingCustomDelimiter(matcher);
        }
        return Arrays.asList(text.split(DELIMITER_PATTERN));
    }

    private static List<String> splitUsingCustomDelimiter(Matcher matcher) {
        String customDelimiter = matcher.group(CUSTOM_DELIMITER_GROUP);
        return Arrays.asList(matcher.group(NUMBERS_GROUP)
                .split(Pattern.quote(customDelimiter)));
    }

    private static int calculateSum(List<String> tokens) {
        return tokens.stream()
                .mapToInt(StringAddCalculator::toPositiveInt)
                .sum();
    }

    private static int toPositiveInt(String token) {
        int number = Integer.parseInt(token);
        if (number < 0) {
            throw new IllegalArgumentException("음수 값은 허용되지 않습니다.");
        }
        return number;
    }

}
