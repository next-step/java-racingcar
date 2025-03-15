package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final String DELIMETER = ",|:";
    public static final String REGEX = "//(.)\n(.*)";

    public static int  splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        Matcher m = Pattern.compile(REGEX).matcher(text);

        if (isCustomDelimeter(m)) {
            String customDelimiter = m.group(1);
            String[] values = m.group(2).split(customDelimiter);

            return sum(values);
        }

        String[] values = text.split(DELIMETER);

        return sum(values);
    }

    private static boolean isCustomDelimeter(Matcher m) {
        return m.find();
    }

    private static int[] toNumbers(String[] values) {
        int[] numbers = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            numbers[i] = toNumber(values[i]);
        }

        return numbers;
    }

    private static int sum(int[] numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

    private static int sum(String[] values) {
        int[] numbers = toNumbers(values);

        return sum(numbers);
    }

    private static int toNumber(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }

        return number;
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }
}
