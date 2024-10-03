package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    public static int splitAndSum(String text) throws IllegalArgumentException {
        if (isNullOrEmpty(text)) {
            return 0;
        }
        return sum(toInts(splitStringsByDelimiter(text)));
    }

    private static Matcher customDelimiter(String text) {
        return Pattern.compile(CUSTOM_DELIMITER).matcher(text);
    }

    private static String[] splitStringsByDelimiter(String text) {
        Matcher m = customDelimiter(text);
        if (m.find()) {
            return m.group(2).split(m.group(1));
        }
        return text.split(DELIMITER);
    }

    private static int[] toInts(String[] strings) {
        int[] numbers = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            int number = Integer.parseInt(strings[i]);
            throwIfNegative(number);
            numbers[i] = number;
        }
        return numbers;
    }

    private static int sum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private static void throwIfNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용하지 않습니다.");
        }
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }
}