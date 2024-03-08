import error.ErrorMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitAddCalculator {



    public static int calculate(String text) {
        if (isBlank(text)) {
            return 0;
        }

        return sum(toInts(split(text)));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] split(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (!matcher.find()) {
            return text.split(",|:");
        } else {
            String delimiter = matcher.group(1);
            return matcher.group(2).split(delimiter);
        }
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            int num = parseInt(values[i]);
            validateNumberRange(num);
            numbers[i] = num;
        }
        return numbers;
    }

    private static int parseInt(String text) {
        validateNumber(text);
        return Integer.parseInt(text);

    }

    private static void validateNumber(String text) {
        Matcher matcher = Pattern.compile("[^0-9-]").matcher(text);
        if (matcher.find()) {
            throw new RuntimeException(ErrorMessage.ERR_NUMBER_FORMAT_MESSAGE.print());
        }
    }

    private static void validateNumberRange(int num) {
        if (num < 0) {
            throw new RuntimeException(ErrorMessage.ERR_NUMBER_RANGE_MESSAGE.print());
        }
    }

    private static int sum(int[] numbers) {
        int result = 0;

        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}
