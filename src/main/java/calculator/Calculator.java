package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private final static String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private final static Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_DELIMITER);
    public static int splitAndSum(String text) {
        if(isNullOrBlank(text)) {
            return 0;
        }

        Matcher m = CUSTOM_PATTERN.matcher(text);

        if (m.find()) {
            return getSum(stringsToInts(getCustomDelimiterArr(m)));
        }

        return getSum(stringsToInts(text.split("[,:]")));
    }

    private static int getSum(int[] values) {
        int sum = 0;
        for(int value: values) {
            sum += value;
        }
        return sum;
    }

    private static int[] stringsToInts(String[] values) {
        int[] ints = new int[values.length];
        String val = "";
        for(int i = 0 ; i < values.length; i++) {
            val = values[i];

            isValidString(val);
            ints[i] = Integer.parseInt(val);
        }

        return ints;
    }

    private static String[] getCustomDelimiterArr(Matcher m) {
        return m.group(2).split(m.group(1));
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isBlank();
    }
    private static void isValidString(String text) {
        if(!isNumber(text)) {
            throw new RuntimeException("input error");
        }
    }
    private static boolean isNumber(String text) {
        try {
            if(Integer.parseInt(text) < 0) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
