package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int CUSTOM_DELIMITER_OTHER_GROUP = 2;

    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        return sum(parsing(split(input)));
    }

    private static String[] split(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_GROUP);
            return matcher.group(CUSTOM_DELIMITER_OTHER_GROUP).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER);
    }

    private static long[] parsing(String[] numbers) {
        long[] newNumbers = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            newNumbers[i] = parseLong(numbers[i]);
        }
        return newNumbers;
    }

    private static long parseLong(String number) {
        long newNumber = Long.parseLong(number);
        if(newNumber < 0) {
            throw new RuntimeException("음수가 입력되었습니다.");
        }
        return newNumber;
    }
    private static int sum(long[] numbers) {
        long sum = 0;
        for (long number : numbers) {
            sum += number;
        }
        if (sum > Integer.MAX_VALUE) {
            throw new RuntimeException("합이 int 범위를 초과한 수가 입력되었습니다.");
        }
        return (int) sum;
    }
}
