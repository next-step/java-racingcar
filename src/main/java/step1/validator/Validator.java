package step1.validator;

import step1.enums.OperationSymbol;
import step1.util.StringUtil;

import java.util.List;
import java.util.stream.IntStream;

public class Validator {

    private static final int MIN_TOKENS_SIZE = 3;

    public static void validateInput(String input) {

        if (input == null || StringUtil.isConsistOnlyWhiteSpace(input)) {
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }
    }

    public static void validateToken(List<String> tokens) {

        validateTokenSize(tokens);
        validateSymbol(tokens);
    }

    private static void validateTokenSize(List<String> tokens) {

        if (tokens.size() < MIN_TOKENS_SIZE || !isOddNumber(tokens.size())) {
            throw new IllegalArgumentException("연산자의 개수가 유효하지 않습니다.");
        }
    }

    private static void validateSymbol(List<String> tokens) {

        IntStream.range(0, tokens.size())
                .filter(Validator::isOddNumber)
                .mapToObj(tokens::get)
                .forEach(OperationSymbol::from);
    }

    private static boolean isOddNumber(int number) {

        return number % 2 == 1;
    }
}
