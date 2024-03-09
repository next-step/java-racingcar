package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int calculate(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        return sum(split(str));
    }

    private static String[] split(String str) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return str.split("[,:]");
    }

    private static int sum(String[] tokens) {
        int sum = 0;
        for (String s : tokens) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }

}
