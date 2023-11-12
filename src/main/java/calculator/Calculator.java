package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final int DEFAULT_ZERO = 0;

    public static int calculate(String text) {
        if (isBlank(text)) {
            return DEFAULT_ZERO;
        }
        return sum(convertIntArray(split(text)));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(",|:");
    }

    private static int[] convertIntArray(String[] values) {
        int[] intArr = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            intArr[i] = convertStringToNaturalNumber(values[i]);
        }
        return intArr;
    }

    private static int convertStringToNaturalNumber(String value) {
        try {
            if (isNegative(Integer.parseInt(value))) {
                throw new RuntimeException("음수는 허용하지 않습니다.");
            }
        } catch (NumberFormatException exception) {
            throw new RuntimeException("숫자 이외의 문자는 허용하지 않습니다.");
        }
        return Integer.parseInt(value);
    }

    private static boolean isNegative(int number) {
        return number < 0;
    }

    private static int sum(int[] values) {
        int sum = DEFAULT_ZERO;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }
}
