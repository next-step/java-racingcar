package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {
        if(text == null || text.isBlank()){
            return 0;
        }

        Matcher m = PATTERN.matcher(text);
        if(m.find()) {
            String customDelimiter = m.group(1);
            return split(customDelimiter, m.group(2));
        }
        return split("[,|:]", text);
    }

    private static int split( String customDelimiter, String text) {
        String[] tokens = text.split(customDelimiter);
        return sum(tokens);
    }

    private static int sum( String[] values) {
        int result = 0;
        for (String value : values) {
            int num = Integer.parseInt(value);
            if(num <0) throw new RuntimeException();
            result += num;
        }
        return result;
    }
}
