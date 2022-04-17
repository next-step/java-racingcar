package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER);

    private StringAddCalculator() {
        throw new IllegalStateException("Util class");
    }

    public static int splitAndSum(String text) {

        if (isEmptyOrNull(text))  {
            return 0;
        }


        Matcher matcher = pattern.matcher(text);

        if(matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] values = matcher.group(2).split(customDelimiter);
            return sum(toInts(values));
        }

        String[] values =  text.split(DEFAULT_DELIMITER);
        return sum(toInts(values));
    }

    private static boolean isEmptyOrNull(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(int[] values) {
        return Arrays.stream(values).reduce(0, Integer::sum);
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i <values.length ; i++) {
            numbers[i] = toInt(values[i]);
        }
        return numbers;
    }

    private static int toInt(String number) {
        int intItem = Integer.parseInt(number);
        if (intItem < 0) {
            throw new RuntimeException("음수가 들어올 수 없습니다.");
        }
        return intItem;
    }
}
