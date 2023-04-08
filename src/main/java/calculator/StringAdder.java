package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdder {
    public static final int ZERO = 0;
    public static String regex = ",|:";

    public static int splitAndSum(String text) {
        if (isBlank(text)) return ZERO;
        if (isContainsNegative(text)) throw new RuntimeException();
        return sum(split(text));
    }

    private static boolean isContainsNegative(String text) {
        return text.contains("-");
    }

    private static String[] split(String text) {
        if(hasCustomDelimeter(text)) {
            addCustomDelimeterToRegex(text);
            text = getTextWithoutCustomDelimeter(text);
        }
        return text.split(regex);
    }

    private static String getTextWithoutCustomDelimeter(String text) {
        text = text.substring(5);
        return text;
    }

    private static void addCustomDelimeterToRegex(String text) {
        regex += "|" + text.substring(2, 3);
    }

    private static boolean hasCustomDelimeter(String text) {
        return text.length() >= 2 && text.substring(0, 2).equals("//") && text.substring(3, 5).equals("\\n");
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(String[] numbers) {
        int sum = ZERO;
        for (String value : numbers) {
            sum += Integer.parseInt(value);
        }
        return sum;
    }
}
