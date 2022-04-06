package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    public static int splitAndSum(String text) {

        if (text == null || text.isBlank()) {
            return 0;
        }

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(text);

        if(matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] values = matcher.group(2).split(customDelimiter);
            return sum(toInts(values));
        }

        String[] values =  text.split(DEFAULT_DELIMITER);
        return sum(toInts(values));
    }

    private static int sum(int[] values) {
        int result = 0;
        for (int item : values) {
            result += item;
        }
        return result;
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i <values.length ; i++) {
            numbers[i] = toInt(values[i]);
        }
        return numbers;
    }

    private static int toInt(String item) {
        int intItem = Integer.parseInt(item);
        if (intItem < 0) {
            throw new RuntimeException("음수가 들어올 수 없습니다.");
        }
        return intItem;
    }
}
