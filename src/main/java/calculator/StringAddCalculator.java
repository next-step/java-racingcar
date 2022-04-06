package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String defaultDelimiter = "[,:]";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        String[] tokens = text.split(defaultDelimiter);

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
