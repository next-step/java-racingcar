package study.step2;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER;
    private static final String CUSTOM_DELIMITER;
    private static final Pattern CUSTOM_DELIMITER_PATTERN;

    static {
        DEFAULT_DELIMITER = ":|,";
        CUSTOM_DELIMITER = "//(.*)\n(.*)";
        CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);
    }

    public static int calculate(String input) {
        if (isEmptyOrNull(input)) return 0;

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String targetString = matcher.group(2);
            return sum(splitString(targetString, customDelimiter));
        }
        
        String[] split = splitString(input, DEFAULT_DELIMITER);
        if (split.length > 1) {
            return sum(split);
        }

        try {
            int number = Integer.parseInt(input);
            if (isNegativeNumber(number)) throw new RuntimeException("음수입니다.");
            return number;
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닙니다.");
        }
    }

    private static boolean isEmptyOrNull(String input) {
        return input == null || input.isBlank();
    }

    private static boolean isNegativeNumber(int number) {
        return number < 0;
    }

    private static String[] splitString(String string, String delimiter) {
        return string.split(delimiter);
    }

    private static int sum(String[] strings) {
        int[] ints = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        if (Arrays.stream(ints).anyMatch(StringAddCalculator::isNegativeNumber)) {
            throw new RuntimeException("음수입니다.");
        }
        return Arrays.stream(ints).sum();
    }
}
