package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToken {

    private static final String DEFAULT_VALUE = "0";
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    private final String delimiter;
    private final String text;

    private StringToken(String delimiter, String text) {
        this.delimiter = delimiter;
        this.text = text;
    }


    public static StringToken from(String text) {
        return createStringToken(getDefaultIfEmpty(text));
    }

    private static String getDefaultIfEmpty(String text) {
        if (isEmpty(text)) {
            return DEFAULT_VALUE;
        }
        return text;
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isBlank();
    }

    private static StringToken createStringToken(String text) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            return new StringToken(matcher.group(1), matcher.group(2));
        }
        return new StringToken(DEFAULT_DELIMITER, text);
    }

    public int[] toIntArray() {
        return toInts(split(text, delimiter));
    }

    private String[] split(String text, String delimiter) {
        return text.split(delimiter);
    }

    private int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = toPositiveInt(values[i]);
        }
        return numbers;
    }

    private int toPositiveInt(String value) {
        try {
            int valueAsInt = Integer.parseInt(value);
            throwIfNegative(valueAsInt);
            return valueAsInt;
        } catch (NumberFormatException e) {
            throw new RuntimeException("토크닝 대상에 숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    private void throwIfNegative(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }
}