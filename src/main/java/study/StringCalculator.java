package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final String SEPARATOR = ",|:";
    public static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";
    public static final String NUMERIC_REGULAR_EXPRESSION = "^\\d+$";
    public static final Pattern pattern = Pattern.compile(NUMERIC_REGULAR_EXPRESSION); //이렇게되면?

    public static int splitAndSum(String text) {
        return sum(toIntArray(split(blankToZero(text))));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static String blankToZero(String text) {
        if(isBlank(text)) {
            return "0";
        }
        return text;
    }

    private static String[] split(String text) {
        String separator = SEPARATOR;
        Matcher m = Pattern.compile(CUSTOM_SEPARATOR).matcher(text);
        if (m.find()) {
            separator = m.group(1);
            text = m.group(2);
        }
        return text.split(separator);
    }

    private static int sum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private static int[] toIntArray(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            int number = toInt(values[i]);
            numbers[i] = number;
        }
        return numbers;
    }

    private static int toInt(String values) {
        Matcher matcher = pattern.matcher(values);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("기본 구분자 또는 커스텀 구분자를 확인해주세요.");
        }

        int number = Integer.parseInt(values);
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용하지 않습니다.");
        }
        return number;
    }
}
