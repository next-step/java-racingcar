package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static int sum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String delimiters = ",:";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            return arrayToSum(split(m.group(2), delimiters + m.group(1)));
        }
        return arrayToSum(split(text, delimiters));
    }

    private static String[] split(String text, String delimiters) {
        String[] numbers = text.split("[" + delimiters + "]");
        if (numbers.length == 0) throw new IllegalStateException();
        return numbers;
    }

    private static int arrayToSum(String[] numbers) {
        return Arrays.stream(numbers).filter(Calculator::validateNumber).mapToInt(Integer::parseInt).sum();
    }

    private static boolean validateNumber(String string) {
        if (!string.matches("[0-9]+")) throw new IllegalArgumentException();
        return true;
    }
}
