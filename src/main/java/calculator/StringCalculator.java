package calculator;

import java.util.Arrays;

/**
 * 문자열 계산기
 */
public class StringCalculator {

    /**
     * 입력으로 주어진 문자열의 합을 계산한다.
     *
     * @param text 합을 계산할 문자열 (ex. "1;2;3")
     * @return 계산된 문자열의 합
     */
    public static int sum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        String[] tokens = TokenUtils.generateTokensFromText(text); //구분자로 텍스트를 나눠서 토큰을 생성함
        TokenUtils.validateTokens(tokens); //토큰이 음수이거나 숫자가 아닌 문자를 포함하는지 검증함

        return Arrays.stream(tokens)
            .mapToInt(Integer::parseInt)
            .sum();
    }

    /**
     * 문자열이 null 이거나 공백인지 검사한다.
     *
     * @param text 검사할 문자열
     * @return null 혹은 공백 여부
     */
    private static boolean isNullOrEmpty(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }
        return false;
    }
}
