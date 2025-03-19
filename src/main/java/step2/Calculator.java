package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static int add(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }

        if (text.startsWith("//")) {
            return parseWithCustomDelimiter(text);
        }

        return parseWithDefaultDelimiter(text);
    }

    private static int parseWithDefaultDelimiter(String text) {
        String regex = ",|:";
        String[] strings = text.split(regex);
        return calculateSum(strings);
    }

    private static int parseWithCustomDelimiter(String text) {
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] strings = matcher.group(2).split(customDelimiter);

            return calculateSum(strings);
        }

        return 0;
    }

    private static int calculateSum(String[] strings) {
        int sum = 0;
        for (String string : strings) {
            parseValidNumber(string);
            sum += Integer.parseInt(string);
        }
        return sum;
    }

    private static int parseValidNumber(String text) {
        try {
            int number = Integer.parseInt(text);
            throwIfNegative(number);
            return number;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private static void throwIfNegative(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }
}
