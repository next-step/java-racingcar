package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringCalculator {

    private StringCalculator() {
        throw new IllegalCallerException("객체 생성이 불필요합니다.");
    }

    private static final int DEFAULT_VALUE = 0;
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int calculate(String text) {
        if (isEmpty(text)) {
            return DEFAULT_VALUE;
        }
        int[] numbers = tokenizeAsInt(text);
        return sum(numbers);
    }

    private static boolean isEmpty(String text) {
        return Objects.isNull(text) || text.isEmpty();
    }

    private static int[] tokenizeAsInt(String text) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String textWithoutPattern = matcher.group(2);
            return toInts(split(textWithoutPattern, customDelimiter));
        }
        return toInts(split(text, DEFAULT_DELIMITER));
    }

    private static String[] split(String text, String delimiter) {
        return text.split(delimiter);
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = throwIfNegative(toInt(values[i]));
        }
        return numbers;
    }

    private static int toInt(String values) {
        return Integer.parseInt(values);
    }

    private static int throwIfNegative(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return number;
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
