package StringAddCalculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class StringAddCalculator {
    public static int splitAndSum(String text) throws Exception {
        if (checkNullOrEmpty(text)) {
            return 0;
        }

        String[] tokens = splitText(text);
        if (tokens.length == 0) {
            return 0;
        }

        int sum = sumAllTokens(tokens);
        return sum;
    }

    private static boolean checkNullOrEmpty(String text) {
        if (Objects.isNull(text)) {
            return true;
        }
        if (text.isEmpty()) {
            return true;
        }
        return false;
    }

    private static String[] splitText(String text) {
        String delimiter = ",|:";
        String[] tokens;

        // java.util.regex 패키지의 Matcher, Pattern import
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(delimiter+"|"+customDelimiter);
            // 덧셈 구현
        } else {
            tokens = text.split(delimiter);
        }
        return tokens;
    }

    private static int sumAllTokens(String[] tokens) throws Exception {
        int sum = 0;
        for (String token : tokens) {
            int num = Integer.parseInt(token);
            if (num < 0) {
                throw new RuntimeException("입력 값은 0보다 커야 합니다.");
            } else {
                sum += Integer.parseInt(token);
            }
        }
        return sum;
    }
}
