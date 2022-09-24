package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String SEPERATOR = ",|:";

    public int calculate(String text) {
        if (isBlank(text)) {
            return 0;
        }

        if (text.contains("-")) {
            throw new RuntimeException();
        }

        return toSum(toInt(split(text)));
    }

    private String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] token = m.group(2).split(customDelimiter);
            return token;
        }
        return text.split(SEPERATOR);
    }

    private boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private int toSum(int[] numbers) {
        int sum = 0;
        for (int number: numbers) {
            sum += number;
        }
        return sum;
    }

    private int[] toInt(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }
}
