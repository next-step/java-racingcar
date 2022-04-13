package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        Integer values = customSplitAndSum(text);
        if (values != null) {
            return values;
        }

        return sum(split(text));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static Integer customSplitAndSum(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (!m.find())
            return null;

        String customDelimiter = m.group(1);
        String[] values = m.group(2).split(customDelimiter);

        return sum(values);
    }

    private static String[] split(String text) {
        return text.split("[,:]");
    }

    private static int sum(String[] values) {
        int sum = 0;

        for (int number : toInts(values)) {
            sum += number;
        }

        return sum;
    }

    private static List<Integer> toInts(String[] values) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < values.length; i++) {
            numbers.add(toInt(values[i]));
        }

        return numbers;
    }

    private static int toInt(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new NegativeNumberException(number);
        }
        return number;
    }

}
