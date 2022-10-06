package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String target) {
        if(isBlank(target))
            return 0;

        if(target.length() == 1) {
            return new Positive(target).getNumber();
        }

        Matcher m = PATTERN.matcher(target);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return sum(tokens);
        }

        String[] splitResults = target.split(",|:");
        return sum(splitResults);

    }

    private static boolean isBlank(String target) {
        return target == null || target.isBlank();
    }

    private static int sum(String[] numberStr) {
        int sum = 0;
        for (String s : numberStr) {
            var positive = new Positive(s);
            sum += positive.getNumber();
        }
        return sum;
    }
}
