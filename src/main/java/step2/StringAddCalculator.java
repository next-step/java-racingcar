package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        return getSumValue(split(input));
    }

    public static String[] split(String text) {
        String delimiter = ":|,";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (m.find()) {
            delimiter += "|" + m.group(1);
            text = m.group(2);
        }

        return text.split(delimiter);
    }

    private static boolean isNullOrEmpty(String text) {
        if (text == null) {
            return true;
        }
        if (text.isEmpty()) {
            return true;
        }
        return false;
    }

    private static int convertPositiveNumber(String text) {
        try {
            int number = Integer.parseInt(text);
            if (number > 0) {
                return number;
            } else {
                throw new RuntimeException("음수입력 불가");
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("NumberFormatException");
        }
    }

    private static int getSumValue(String[] numbers){
        return Arrays.stream(numbers)
                .map(
                        s -> convertPositiveNumber(s)
                ).mapToInt(i -> i).sum();
    }
}
