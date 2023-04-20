package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

   private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");
   private static final int COMMA = 1;
    private static final int ASTERISK = 1;

    public int splitAndSum(String value) {

        if (checkNullEmpty(value)) {
            return 0;
        }
        return sum(stringSeparation(stringSeparatorSeparation(value)));
    }

    private boolean checkNullEmpty(String value) {
       return value == null || value.isEmpty();
    }

    private String[] stringSeparatorSeparation(String value) {

        String[] number;

        Matcher m = pattern.matcher(value);

        if (m.find()) {
            String customDelimiter = m.group(COMMA);
            number = m.group(ASTERISK).split(customDelimiter);
        }
        number = value.split(",|:");

        return number;
    }

    private int checkNegative(int value) {
        if (0 > value) {
            throw new RuntimeException();
        }
        return value;
    }

    private int[] stringSeparation(String[] values) {
        int[] ints = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            ints[i] = checkNegative(Integer.valueOf(values[i]));
        }
        return ints;
    }

    private int sum(int[] ints) {
        int sum = 0;
        for (int temp : ints) {
            sum += temp;
        }
        return sum;
    }
}

