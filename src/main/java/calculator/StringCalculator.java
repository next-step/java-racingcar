package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    public static final String DEFAULT_DELIMITER = ",|\\:";

    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] elements = removeCustomDelimiter(input).split(getDelimiter(input));

        int sum = 0;
        for (int i = 0; i < elements.length; i++) {
            int num = parseInt(elements[i]);
            if (num < 0) {
                throw new RuntimeException();
            }
            sum += num;
        }
        return sum;
    }

    private static String getDelimiter(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            return m.group(1);
        }
        return DEFAULT_DELIMITER;
    }

    private static String removeCustomDelimiter(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            return m.group(2);
        }
        return text;
    }
}
