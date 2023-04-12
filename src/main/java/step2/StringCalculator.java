package step2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author : 0giri
 * @since : 2023/04/12
 */
public class StringCalculator {

    private static final int DEFAULT_NUMBER = 0;
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return DEFAULT_NUMBER;
        }
        String[] values = split(text);
        List<Integer> numbers = toInts(values);
        Positives positives = new Positives(numbers);
        return positives.sum();
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] split(String text) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String target = matcher.group(2);
            return target.split(customDelimiter);
        }
        return text.split(DEFAULT_DELIMITER_REGEX);
    }

    private static List<Integer> toInts(String[] values) {
        return Arrays.stream(values)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
