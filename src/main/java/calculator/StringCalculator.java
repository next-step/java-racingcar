package calculator;

import java.util.Arrays;

public class StringCalculator {

    public static int sum(final String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        final String[] tokens = TokenUtils.generateTokensFromText(text); //구분자로 텍스트를 나눠서 토큰을 생성함
        TokenUtils.validateTokens(tokens); //토큰이 음수이거나 숫자가 아닌 문자를 포함하는지 검증함

        return sumTokens(tokens);
    }

    private static boolean isNullOrEmpty(final String text) {
        return text == null || text.isEmpty();
    }

    private static int sumTokens(final String[] tokens) {
        return Arrays.stream(tokens)
            .mapToInt(Integer::parseInt)
            .sum();
    }
}
