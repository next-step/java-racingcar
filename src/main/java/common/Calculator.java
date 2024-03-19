package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private Calculator() {
    }

    private static final int ZERO = 0;

    public static int calculate(String input) {
        if (isBlank(input)){
            return ZERO;
        }
        return sum(toInts(split(input)));
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    private static int sum(int[] values) {
        int result = 0;
        for (int i = 0; i < values.length; i++) {
            result += values[i];
        }
        return result;
    }

    private static int[] toInts(String[] values) {
        int[] ints = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            int intValue = Integer.parseInt(values[i]);
            if (intValue < 0) {
                throw new RuntimeException("input should greater than 0");
            }
            ints[i] = intValue;
        }
        return ints;
    }


    private static String[] split(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if(!m.find()){
            return StringUtils.split(input, ",|:");
        }

        String customDelimiter = m.group(1);
        return StringUtils.split(m.group(2), customDelimiter);
    }
}
