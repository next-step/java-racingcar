package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private final static String DELIMITER_DEFUALT_REGEXP = ",|:";
    private final static String DELIMITER_CUSTOM_REGEXP  = "//(.)\n(.*)";

    public static int splitAndSum(String text) {

        if(text == null || text.isBlank())return 0;

        int result = 0;

        Matcher m = Pattern.compile(DELIMITER_CUSTOM_REGEXP).matcher(text);
        if(m.find()){
            String customDelimiter = m.group(1);
            String[] values = m.group(2).split(customDelimiter);
            return sum(result, values);
        }

        String[] values = text.split(DELIMITER_DEFUALT_REGEXP);
        return sum(result, values);
    }

    private static int sum(int result, String[] values) {
        for (String value : values) {
            int number = Integer.parseInt(value);
            result += number;
        }
        return result;
    }

}
