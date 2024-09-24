package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String delimiters = ",|:";
    private static Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {
        if (checkNullOrEmpty(text)) {
            return 0;
        }

        if (text.contains("//")) {
            String[] numbers = splitStringWithRegex(text);
            return addNumbers(numbers);
        }

        String[] numbers = splitString(text);
        return addNumbers(numbers);
    }

    private static boolean checkNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] splitString(String text) {
        return text.split(delimiters);
    }

    private static String[] splitStringWithRegex(String text) {
        Matcher m = pattern.matcher(text);

        if (m.find()) {
            String delimiter = m.group(1);
            return m.group(2).split(delimiter);
        }
        return new String[0];
    }

    private static int addNumbers(String[] numbers) {
        checkMinusNumber(numbers);

        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }

        return result;
    }

    private static void checkMinusNumber(String[] numbers) {
        for (String number : numbers) {
            if (Integer.parseInt(number) < 0) {
                throw new RuntimeException();
            }
        }
    }
}
