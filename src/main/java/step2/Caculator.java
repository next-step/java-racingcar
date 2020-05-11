package step2;

import java.util.Arrays;

public class Caculator {

    private static final String WHITE_SPACE_REGEX = "\\s+";
    private static final String TWO_LENGTH_SEPERATE_REGEX = "(?<=\\G.{2})";

    private Caculator() {
    }

    public static int caculate(final String inputString) {
        validateInputString(inputString);

        String initValue = inputString.substring(0, 1);
        String[] inputTokens = inputString.substring(1)
                .replaceAll(WHITE_SPACE_REGEX, "")
                .split(TWO_LENGTH_SEPERATE_REGEX);

        return Integer.parseInt(Arrays.stream(inputTokens)
                .reduce(initValue, (prevValue, inputToken) -> {
                    validateInputToken(inputToken);

                    String[] operend = inputToken.split("");
                    String expression = operend[0];
                    String nextValue = operend[1];

                    return String.valueOf(Operator.from(expression).result(prevValue, nextValue));
                }));
    }

    private static void validateInputToken(String inputToken) {
        if (inputToken.length() != 2) {
            throw new IllegalArgumentException(String.format("'%s' 계산식이 올바르지 않습니다.", inputToken));
        }
    }

    private static void validateInputString(String inputString) {
        if (inputString == null || inputString.trim().equals("")) {
            throw new IllegalArgumentException("null과 공백 문자 사용 할 수 없습니다");
        }
    }
}
