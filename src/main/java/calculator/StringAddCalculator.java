package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] splitedByDelimiter = matcher.group(2).split(customDelimiter);
            return stringArraySum(splitedByDelimiter);
        }

        String[] splitedString = text.split(",|:");
        return stringArraySum(splitedString);
    }

    private static int stringArraySum(String[] splitedString) {
        int result = 0;
        for (String each : splitedString) {
            result += Integer.parseInt(each);
        }
        return result;
    }
}
