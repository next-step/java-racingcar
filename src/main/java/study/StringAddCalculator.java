package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public int splitAndSum(String value) {

        if (checkNull_Empty(value) == 0) {
            return 0;
        }
        return sum(stringSeparation(checkSeparator(value)));
    }

    public int checkNull_Empty(String value) {
        if (value == null || value.isEmpty()) {
            return 0;
        }

        return -1;
    }

    public String[] checkSeparator(String value) {

        String[] number;

        Matcher m = pattern.matcher(value);

        if (m.find()) {
            String customDelimiter = m.group(1);
            number = m.group(2).split(customDelimiter);
        }
        number = value.split(",|:");

        return number;
    }

    public int checkNegative(int value) {
        if (0 > value) {
            throw new RuntimeException();
        }
        return value;
    }

    public int[] stringSeparation(String[] values) {
        int[] ints = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            ints[i] = checkNegative(Integer.valueOf(values[i]));
        }
        return ints;
    }

    public int sum(int[] ints) {
        int sum = 0;
        for (int temp : ints) {
            sum += temp;
        }
        return sum;
    }
}

