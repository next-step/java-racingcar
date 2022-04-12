package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if(text == null || text.isBlank()) {
            return 0;
        }

        String delimiter = "[,:]";
        delimiter += "|" + getCustomDelimiter(text);
        text = getNumberString(text);

        String[] values = text.split(delimiter);
        return sum(values);
    }

    private static String getCustomDelimiter(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()) {
            return m.group(1);
        }
        return null;
    }

    private static String getNumberString(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()) {
            return m.group(2);
        }
        return text;
    }

    private static int getNumber(String value) {
        return parseValidNumber(value);
    }

    private static int parseValidNumber(String value) {
        int number = Integer.parseInt(value);

        if(number < 0) {
            throw new RuntimeException();
        }

        return number;
    }

    private static int sum(String[] values) {
        int sum = 0;
        for (String value : values) {
            sum += getNumber(value);
        }
        return sum;
    }
}
