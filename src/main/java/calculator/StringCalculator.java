package calculator;

import java.util.Arrays;

public class StringCalculator {

    public static int sum(String text) {
        if (isNullOrEmpty(text)) return 0;

        String[] tokens = TokenUtils.generateTokensFromText(text); //구분자로 텍스트를 나눠서 토큰을 생성함
        TokenUtils.validateTokens(tokens); //토큰이 음수이거나 숫자가 아닌 문자를 포함하는지 검증함

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
}
