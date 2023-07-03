package calculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    public static int sum(String text) {
        if (isNullOrEmpty(text)) return 0;

        String[] tokens = TokenUtils.generateTokensFromText(text);
        TokenUtils.validateToken(tokens);

        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static boolean isNullOrEmpty(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }
        return false;
    }

    /*
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
     */
}
