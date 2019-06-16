package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * 기능 :
 * - 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
 * - 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다.
 *   즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
 *   예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
 *
 * - 사용자 입력
 * - 입력된 문자열을 분리
 *   1) 입력 값이 null, 공백 : IllegalArgumentException
 *   2) token의 개수가 3개 이하이면 안된다.
 *   3) token의 개수가 홀수개여야 한다.
 *   4) token에서 홀수번째 녀석들은 숫자여야 한다.
 *   5) token에서 짝수번째 녀석들은 사칙연산 기호여야 한다. (사칙연산 기호 이외의 기호 : IllegalArgumentException)
 */
public class Calculator {

    private static final String DELIMITER = " ";

    private static final String PLUS_SYMBOL = "+";
    private static final String MINUS_SYMBOL = "-";
    private static final String MULTIPLY_SYMBOL = "*";
    private static final String DIVID_SYMBOL = "/";

    private static final List<String> ENABLED_ARITHMETIC_SYMBOLS = Arrays.asList(PLUS_SYMBOL, MINUS_SYMBOL, MULTIPLY_SYMBOL, DIVID_SYMBOL); // Arithmetic symbols

    private static final String ILLEGAL_ARGUMENT_EXCEPTION_MSG = "입력값을 제대로 입력해주세요.";

    public int calculate(String input) {
        validateIsNotEmpty(input); // 공백 or null이 아닌지 판단

        // tokenize해서 분리
        List<String> tokens = tokenize(input);

        // token 사이즈 확인
        validateSizeOf(tokens);

        // validate numbers with passing function
        validate(tokens, n -> n % 2 == 0, this::validateNumber);

        // validate symbols with passing function
        validate(tokens, n -> n % 2 == 1, this::validateSymbol);

        return calculate(tokens);
    }

    private int calculate(List<String> tokens) {

        int result = Integer.valueOf(tokens.get(0));

        for(int i = 1; i < tokens.size(); i += 2) {
            result = calculate(result, tokens.get(i), tokens.get(i + 1));
        }

        return result;
    }

    private int calculate(int result, String symbol, String number) {

        switch (symbol) {

            case PLUS_SYMBOL:
                result += Integer.valueOf(number);
                break;
            case MINUS_SYMBOL:
                result -= Integer.valueOf(number);
                break;
            case MULTIPLY_SYMBOL:
                result *= Integer.valueOf(number);
                break;
            case DIVID_SYMBOL:
                result /= Integer.valueOf(number);
                break;
            default:
                throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MSG);
        }

        return result;

    }

    List<String> tokenize(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }

    void validate(List<String> tokens, IntPredicate predicate, Consumer<String> validationConsumer) {
        IntStream.range(0, tokens.size())
                .filter(predicate)
                .mapToObj(tokens::get)
                .forEach(validationConsumer);
    }

    void validateSizeOf(List<String> tokens) {
        int size = tokens.size();

        if (size < 3 || size % 2 == 0) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MSG);
        }
    }

    void validateIsNotEmpty(String input) {
        if (null == input || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MSG);
        }
    }

    void validateNumber(String stringNumber) {
        try {
            Integer.valueOf(stringNumber);
        } catch (Exception ignored) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MSG);
        }
    }

    void validateSymbol(String symbol) {
        if(!ENABLED_ARITHMETIC_SYMBOLS.contains(symbol)) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MSG);
        }
    }

}
