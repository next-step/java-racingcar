package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) throws IllegalArgumentException {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        Matcher m = customDelimeter(text);
        if (m.find()) {
            return stringAddCalculation(splitStringsByDelimeter(m.group(2), m.group(1)));
        }

        return stringAddCalculation(splitStringsByDelimeter(text, "[,:]"));
    }

    private static Matcher customDelimeter(String text) {
        return Pattern.compile("//(.)\n(.*)").matcher(text);
    }

    private static String[] splitStringsByDelimeter(String text, String delimeter) {
        return text.split(delimeter);
    }

    private static int stringAddCalculation(String[] strings) {
        int result = 0;
        for (String s : strings) {
            throwIfNegative(s);
            result += parseStringToInt(s);
        }
        return result;
    }

    private static void throwIfNegative(String s) {
        if (parseStringToInt(s) < 0) {
            throw new IllegalArgumentException();
        }
    }

    private static int parseStringToInt(String s) {
        return Integer.parseInt(s);
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
