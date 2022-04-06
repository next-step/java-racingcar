package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEXP = "//(.)\n(.*)";
    private static final Pattern PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEXP);

    public static int splitAndSum(String text) {
        if(isBlank(text)){
            return 0;
        }

        Matcher m = PATTERN.matcher(text);
        if(m.find()) {
            String customDelimiter = m.group(1);
            return split(customDelimiter, m.group(2));
        }

        return split(DEFAULT_DELIMITER, text);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int split(String delimiter, String text) {
        String[] tokens = text.split(delimiter);
        return sum(toInts(tokens));
    }

    private static PositiveInteger[] toInts(String[] values) {
        PositiveInteger[] numbers = new PositiveInteger[values.length];
        for(int i=0; i<values.length; i++) {
            numbers[i] = new PositiveInteger(values[i]);
        }
        return numbers;
    }

    private static int sum(PositiveInteger[] numbers) {
        int sum = 0;
        for (PositiveInteger number : numbers) {
            sum += number.getNumber();
        }
        return sum;
    }
}
