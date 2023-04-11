package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    static public int splitAndSum(String text) {
        if (validateText(text)) {
            return 0;
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return sum(tokens);
        }
        return sum(text.split(",|:"));
    }

    static private boolean validateText(String text) {
        return text == null || text.isEmpty();
    }

    static private int sum(String[] tokens) {
        int result = 0;
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new RuntimeException("음수는 계산할 수 없습니다.");
            }
            result += number;
        }
        return result;
    }

}
