package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern customPattern = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String source) {
        if (source == null || source.isEmpty()) {
            return 0;
        }

        Matcher m = customPattern.matcher(source);

        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);

            return calculateSourceItems(tokens);
        }

        String[] tokens = source.split(DEFAULT_DELIMITER);

        return calculateSourceItems(tokens);
    }

    private static int calculateSourceItems(String[] items) throws RuntimeException{
        int sum = 0;

        for (String item : items) {
            PositiveInteger positiveInteger = new PositiveInteger(item);
            sum += positiveInteger.getNumber();
        }

        return sum;
    }
}
