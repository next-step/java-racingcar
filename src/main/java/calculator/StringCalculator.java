package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final int ZERO = 0;
    public static final String DELIMITER = "[,:]";
    public static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public static int splitAndSum(String text) {

        if (isBlank(text)) {
            return ZERO;
        }

        return sum(toInts(split(text)));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }


    private static String[] split(String text) {

        String[] m = customSplit(text);
        if (m != null) return m;

        return text.split(DELIMITER);
    }

    private static String[] customSplit(String text) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return null;
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for(int i=0; i< values.length; i++) {
            int number = Integer.parseInt(values[i]);
            checkNegative(number);
            numbers[i] = number;
        }
        return numbers;
    }

    private static void checkNegative(int number) {
        if(number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }

    private static int sum(int[] numbers) {
        int sum = ZERO;
        for(int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
