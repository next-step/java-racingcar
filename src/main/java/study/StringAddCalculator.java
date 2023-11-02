package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (!isNullEmpty(input)) {
            return sumElement(splitInput(input));
        }
        return 0;
    }

    private static int sumElement(String[] elements) {
        int result = 0;
        for (String element : elements) {
            int number = chkNumber(element);
            if (number < 0) {
                throw new RuntimeException("0 이상 양수만 입력 가능!!");
            }
            result += number;
        }
        return result;
    }

    private static String[] splitInput(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            return m.group(2).split(m.group(1));
        }
        return input.split(",|:");
    }

    private static int chkNumber(String element) {
        try {
            return Integer.parseInt(element);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isNullEmpty(String input) {
        return input == null || input.isEmpty();
    }
}