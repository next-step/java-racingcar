package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final int ZERO = 0;
    public static final String REGEX = "//(.)\n(.*)";

    public static int splitAndSum(String text){
        if (isBlank(text)) {
            return ZERO;
        }

        return sum(toInts(split(text)));
    }

    private static String[] split(String text) {
        Matcher m = Pattern.compile(REGEX).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return tokens;
        }

        return text.split(",|:");
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(int[] numbers) {
        int sum = ZERO;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    private static int[] toInts(String[] values) {
        int [] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = isNegative(Integer.parseInt(values[i]));
        }
        return numbers;
    }

    private static int isNegative(int num) {
        if (num < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return num;
    }

}
