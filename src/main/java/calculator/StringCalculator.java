package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        Matcher matcher = createMatcher(text);
        if (matcher.find()) {
            return sum(toInts(splitCustomizedText(matcher)));
        }
        return sum(toInts(split(text, DEFAULT_SEPARATOR)));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static Matcher createMatcher(String text) {
        return CUSTOM_SEPARATOR_PATTERN.matcher(text);
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = toPositiveInt(values[i]);;
        }
        return numbers;
    }

    private static int toPositiveInt(String value) {
        int number = validateValueIsNumber(value);
        validateValueIsPositive(number);
        return number;
    }

    private static int validateValueIsNumber(String values) {
        int number;
        try {
            number = Integer.parseInt(values);
        } catch (NumberFormatException exception) {
            throw new RuntimeException("숫자 이의의 값은 입력될 수 없습니다.");
        }
        return number;
    }

    private static void validateValueIsPositive(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 입력될 수 없습니다.");
        }
    }

    private static String[] splitCustomizedText(Matcher matcher) {
        return split(matcher.group(2), matcher.group(1));
    }


    private static String[] split(String text, String separator) {
        return text.split(separator);
    }
}
