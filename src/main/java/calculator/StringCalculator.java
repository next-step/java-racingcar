package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(Pattern.quote(customDelimiter));
            return sumTokens(tokens);
        }
        String[] tokens = input.split(",|:");
        return sumTokens(tokens);
    }

    private static int sumTokens(String[] tokens) {
        return Arrays.stream(tokens)
                .mapToInt(token -> {
                    try {
                        int num = Integer.parseInt(token);
                        if (num < 0) {
                            throw new RuntimeException("음수는 입력 불가합니다.");
                        }
                        return num;
                    } catch (NumberFormatException e) {
                        throw new RuntimeException("숫자 이외의 값은 입력 불가합니다.");
                    }
                })
                .sum();
    }
}
