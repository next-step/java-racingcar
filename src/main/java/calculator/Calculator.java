package calculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    public static int sum(String text) {
        if (text == null || text.isEmpty()) return 0;

        List<Character> delimiter = List.of(',' ,';');

        if (text.startsWith("//") && text.length() >= 4 && text.charAt(3) == '\n') {
            delimiter = List.of(text.charAt(2));
            text = text.substring(4);
        }
        return splitByDelimiterSum(text, delimiter);
        /*
        String[] tokens = text.split(delimiter);
        int result = 0;
        for (String token : tokens) {
            validateToken(token);
            result += Integer.parseInt(token);
        }
         */
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
