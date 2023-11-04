package study.step2;


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
        if (isEmptyOrNull(input)) {
            return 0;
        }
        try {
            return sum(toInt(split(input)));
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닙니다.");
        }
    }

    private static boolean isEmptyOrNull(String input) {
        return input == null || input.isBlank();
    }

    private static String[] split(String string) {
        String delimiter = DEFAULT_DELIMITER;
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(string);
        if (m.find()) {
            string = m.group(2);
            delimiter = m.group(1);
        }
        return string.split(delimiter);
    }

    private static int[] toInt(String[] strings) {
        int[] numbers = new int[strings.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(strings[i]);
        }
        return numbers;
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int n: numbers) {
            sum += validate(n);
        }
        return sum;
    }

    private static int validate(int number) {
        if (isNegative(number)) {
            throw new RuntimeException("음수입니다.");
        }
        return number;
    }

    private static boolean isNegative(int number) {
        return number < 0;
    }
}
