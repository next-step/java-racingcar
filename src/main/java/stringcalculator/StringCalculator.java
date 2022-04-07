package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final String COMMON_DELIMITER = "[,:]";
    public static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    public int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        int result = 0;
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] values = matcher.group(2).split(customDelimiter);
            result = getResult(values, result);
        } else {
            String[] values = input.split(COMMON_DELIMITER);
            result = getResult(values, result);
        }
        return result;
    }

    private int getResult(String[] values, int result) {
        for (String value : values) {
            int number = Integer.parseInt(value);
            result += number;
        }
        return result;
    }
}
