package study.step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String SEPARATOR = ",|:";
    private static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";

    public static int calculate(String input) {
        if (checkNullOrEmpty(input)) {
            return 0;
        }

        String[] numbers = split(input);

        int sum = sum(numbers);
        return sum;
    }

    public static boolean checkNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public static String[] split(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR).matcher(input);

        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }

        return input.split(SEPARATOR);
    }

    public static int sum(String[] numbers) {
        int sum = 0;

        for (String number : numbers) {
            checkNegativeNumber(number);
            sum += Integer.parseInt(number);
        }

        return sum;
    }

    private static void checkNegativeNumber(String number) {
        if (Integer.parseInt(number) < 0) {
            throw new RuntimeException("0보다 작은 수는 입력할 수 없습니다.");
        }
    }


}
