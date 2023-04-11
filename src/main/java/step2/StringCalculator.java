package step2;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator implements Calculator {

    private static final String CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)";
    private static final String DEFAULT_SEPARATOR_REGEX = ",|:";
    public static final int CUSTOM_DELIMITER_GROUP = 1;
    public static final int TEXT_GROUP = 2;
    private static Pattern pattern = Pattern.compile(CUSTOM_SEPARATOR_REGEX);


    public static int splitAndSum(String text) {
        if (validText(text)) return 0;

        String[] split;
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_GROUP);
            split = matcher.group(TEXT_GROUP).split(customDelimiter);
        } else {
            split = text.split(DEFAULT_SEPARATOR_REGEX);
        }

        return Arrays.stream(split)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static boolean validText(String text) {
        return Objects.isNull(text) || text.isBlank() || text.isEmpty();
    }
}
