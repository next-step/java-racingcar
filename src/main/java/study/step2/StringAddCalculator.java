package study.step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] tokens;

        if (text.startsWith("//")) {
            Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
            if (m.find()) {
                String customDelimiter = m.group(1);
                tokens = m.group(2).split(Pattern.quote(customDelimiter));
            } else {
                throw new RuntimeException("커스텀 구분자 형식이 올바르지 않습니다.");
            }
        } else {
            tokens = text.split(",|:");
        }

        int sum = 0;
        for (String token : tokens) {
            int number;
            try {
                number = Integer.parseInt(token);
            } catch (NumberFormatException e) {
                throw new RuntimeException("숫자가 아닌 값이 포함되어 있습니다: " + token);
            }
            if (number < 0) {
                throw new RuntimeException("음수는 허용되지 않습니다: " + number);
            }
            sum += number;
        }
        return sum;
    }
}