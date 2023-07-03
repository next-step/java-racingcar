package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static int sum(String text) {
        if (text == null || text.isEmpty()) return 0;

        String delimiter = "[,;]";

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            delimiter = m.group(1);
            text = m.group(2);
        }

        String lookBehindRegex = "(?<=\\d+)" + delimiter;
        String[] tokens = text.split(lookBehindRegex);

        int result = 0;

        for (String token : tokens) {
            validateToken(token);
            result += Integer.parseInt(token);
        }

        return result;
    }

    public static int splitByDelimiterSum(String text, List<Character> delimiters) {
        boolean prevNum = false;
        String tmp = "";
        int result = 0;
        for (char c : text.toCharArray()) {
            if (prevNum == true && delimiters.contains(c)) {
                prevNum = false;
                validateToken(tmp);
                result += Integer.parseInt(tmp);
                tmp = "";
            } else {
                prevNum = true;
                tmp += c;
            }
        }
        validateToken(tmp);
        result += Integer.parseInt(tmp);

        return result;
    }

    private static void validateToken(String token) {
        try {
            int value = Integer.parseInt(token);
            if (value < 0) throw new RuntimeException("음수는 입력할 수 없습니다.");
        } catch (NumberFormatException e) {
            throw new RuntimeException("유효한 숫자가 아닙니다.");
        }
    }
}
