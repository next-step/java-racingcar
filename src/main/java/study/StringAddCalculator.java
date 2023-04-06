package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        try {
            // null 이거나 공백일 경우
            if (text == null) {
                return 0;
            }
            if (text.isBlank()) {
                return 0;
            }
            // ,나 :으로 구분자 있을 경우

            int sum = 0;
            Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
            if (m.find()) {
                String customDelimiter = m.group(1);
                String[] tokens = m.group(2).split(customDelimiter);
                for (String token : tokens) {
                    int value = Integer.parseInt(token);
                    if (value < 0) {
                        throw new RuntimeException();
                    }
                    sum += value;
                }
            }else {
                String[] split = text.split("[:,]");
                for (String s : split) {
                    int num = Integer.parseInt(s);
                    if (num < 0) {
                        throw new RuntimeException();
                    }
                    sum += num;
                }
            }
            return sum;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
