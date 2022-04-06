package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        int sum = 0;
        String defaultDelimiter = "[,:]";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);

            for (String token : tokens) {
                if (Integer.parseInt(token) < 0) throw new RuntimeException("음수는 나올 수 없습니다.");
                sum += Integer.parseInt(token);
            }
        } else {
            String[] tokens = text.split(defaultDelimiter);

            for (String token : tokens) {
                if (Integer.parseInt(token) < 0) throw new RuntimeException("음수는 나올 수 없습니다.");
                sum += Integer.parseInt(token);
            }
        }

        return sum;
    }
}
