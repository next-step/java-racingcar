package step2;

import java.util.Arrays;

public class Caculator {

    private static final String WHITE_SPACE_REGEX = "\\s+";
    private static final String WHITE_SPACE_REPLACE_CHARACTER = "";

    private static final String TOKEN_SEPERATE_REGEX = "(?<=\\G.{2})";
    private static final String TOKEN_SEPARATOR = "";

    private Caculator() {
    }

    public static int caculate(final String formula) {
        validateFormula(formula);

        String initValue = formula.substring(0, 1);
        String[] inputTokens = formula.substring(1)
                .replaceAll(WHITE_SPACE_REGEX, WHITE_SPACE_REPLACE_CHARACTER)
                .split(TOKEN_SEPERATE_REGEX);

        return Integer.parseInt(Arrays.stream(inputTokens)
                .reduce(initValue, (prevValue, inputToken) -> {
                    validateToken(inputToken);

                    String[] operend = inputToken.split(TOKEN_SEPARATOR);
                    String expression = operend[0];
                    String nextValue = operend[1];

                    return String.valueOf(Operator.from(expression).getResult(prevValue, nextValue));
                }));
    }

    private static void validateToken(String inputToken) {
        if (inputToken.length() != 2) {
            throw new IllegalArgumentException(String.format("'%s' 계산식이 올바르지 않습니다.", inputToken));
        }
    }

    private static void validateFormula(String inputString) {
        if (inputString == null || inputString.trim().equals("")) {
            throw new IllegalArgumentException("null과 공백 문자 사용 할 수 없습니다");
        }
    }
}
