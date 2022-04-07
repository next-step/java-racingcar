package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    static final String DEFAULT_DELIMITER = ",|:";
    static final String CUSTOM_DELIMITER = "//(.)\\n(.*)";

    public static int splitAndSum(String text) {
        int result = 0;

        if(text == null || text.isBlank()) {
            result = 0;
        } else {
            Matcher m = Pattern.compile(CUSTOM_DELIMITER).matcher(text);

            if(m.find()) {
                String customDelimiter = m.group(1);
                String[] values = m.group(2).split(customDelimiter);

                for (String value : values) {
                    int number = Integer.parseInt(value);
                    if(number < 0) {
                        throw new RuntimeException();
                    }
                    result += number;
                }

            } else {
                String[] values = text.split(DEFAULT_DELIMITER);

                for (String value : values) {
                    int number = Integer.parseInt(value);
                    if(number < 0) {
                        throw new RuntimeException();
                    }
                    result += number;
                }
            }
        }

        return result;
    }
}
