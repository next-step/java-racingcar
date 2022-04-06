package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] tokens = text.split(DEFAULT_DELIMITER);
        Matcher m = CUSTOM_DELIMITER.matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        }

        return sum(tokens);
    }

    private static int sum(String[] tokens) {
        int sum = 0;

        for (String token : tokens) {
            if (Integer.parseInt(token) < 0) throw new RuntimeException("음수는 계산할 수 없습니다.");
            sum += Integer.parseInt(token);
        }

        return sum;
    }
}
