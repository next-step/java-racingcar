package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static final String DELIMETER = "[/,,:]";
    public static final String CUSTOM_DELIMETER = "//(.)\n(.*)";

    public static int cal(String text) {
        if (isBlank(text)) {
            return 0;
        }

        return getSum(toInts(split(text)));
    }

    private static String[] split(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMETER).matcher(text);
        if (m.find()) {
            return m.group(2).split(m.group(1));
        }
        return text.split(DELIMETER);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int getSum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = isNegative(Integer.parseInt(values[i]));
        }
        return numbers;
    }

    private static int isNegative(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }
}
