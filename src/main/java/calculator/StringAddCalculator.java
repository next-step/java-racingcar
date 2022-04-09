package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    // 메서드는 가장 작은 단위로 분리!
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEXP = "//(.)\n(.*)";
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int TEXT_GROUP = 2;
    private static final Pattern DELIMITER = Pattern.compile(CUSTOM_DELIMITER_REGEXP);

    private StringAddCalculator() {}

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        Matcher m = DELIMITER.matcher(text);
        String customDelimiter = "";
        if (m.find()) {
            customDelimiter = m.group(CUSTOM_DELIMITER_GROUP);
            String[] values = m.group(TEXT_GROUP).split(customDelimiter);
            return sum(toInts(values));
        }
        String[] values = text.split(DEFAULT_DELIMITER);
        return sum(toInts(values));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        PositiveNumber positiveNumber;
        for (int i = 0; i < values.length; i++) {
            positiveNumber = new PositiveNumber(values[i]);
            numbers[i] = positiveNumber.getNumber();
        }
        return numbers;
    }

}
