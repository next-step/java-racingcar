package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String CUSTOM_REGEX = "//(.)\n(.*)";
    public static final String DEFAULT_REGEX = ",|:";

    public static int splitAndSum(String string) throws RuntimeException {
        if (string == null || string.isEmpty()) {
            return 0;
        }

        if (string.length() == 1) {
            return Integer.parseInt(string);
        }

        int sum = 0;
        Matcher m = Pattern.compile(CUSTOM_REGEX).matcher(string);
        String delimiter;
        String[] tokens;
        if (m.find()) {
            delimiter = m.group(1);
            tokens = m.group(2).split(delimiter);
        } else {
            tokens = string.split(DEFAULT_REGEX);
        }

        int number;
        for (String token : tokens) {
            number = Integer.parseInt(token);
            if (number < 0) {
                throw new RuntimeException("음수는 유효하지 않음.");
            }
            sum += number;
        }

        return sum;
    }

}
