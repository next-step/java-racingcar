package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private final static String BASIC_DELIMITER = "[,:]";

    private final static String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private final static Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public static int splitAndSum(String text) {
        if(isNullOrBlank(text)) {
            return 0;
        }
        return sum(stringsToInts(split(text)));
    }

    private static int sum(int[] values) {
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

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isBlank();
    }

    private static void isValidString(String text) {
        if(!isNegative(text) || !isNumber(text)) {
            throw new RuntimeException("input error");
        }
    }

    private static boolean isNumber(String text) {
        try {
            Integer.parseInt(text);

        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean isNegative(String text) {
        if(Integer.parseInt(text) < 0) {
            return false;
        }
        return true;
    }

    private static String[] split(String text) {
        Matcher m = CUSTOM_PATTERN.matcher(text);
        if (m.find()) {
            String delimiter = m.group(1);
            String target = m.group(2);

            return target.split(delimiter);
        }

        return text.split(BASIC_DELIMITER);
    }

}
