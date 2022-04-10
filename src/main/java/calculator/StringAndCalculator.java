package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAndCalculator {
    public static int splitAndSum(String text) {
        if (Objects.isNull(text) || text.equals("")) {
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return sumValues(tokens);
        } else {
            String[] tokens = text.split("[,:]");
            return sumValues(tokens);
        }
    }

    private static int sumValues(String[] values) {
        int result = 0;
        for (String value : values) {

            int temp = Integer.parseInt(value);
            if (temp < 0) {
                throw new RuntimeException();
            }
            result += temp;
        }
        return result;
    }
}
