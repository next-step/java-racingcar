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

    private Validator validator;

    public Calculator(Validator validator) {
        this.validator = validator;
    }

    public int calculate(String input) {
        validator.validateIsNotEmpty(input); // 공백 or null이 아닌지 판단

        // tokenize해서 분리
        List<String> tokens = tokenize(input);

        // token 사이즈 확인
        validator.validateSizeOf(tokens);

        // validate numbers with passing function
        validator.validate(tokens, n -> n % 2 == 0, validator::validateNumber);

        // validate symbols with passing function
        validator.validate(tokens, n -> n % 2 == 1, validator::validateSymbol);

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

            case Symbols.PLUS_SYMBOL:
                result += Integer.valueOf(number);
                break;
            case Symbols.MINUS_SYMBOL:
                result -= Integer.valueOf(number);
                break;
            case Symbols.MULTIPLY_SYMBOL:
                result *= Integer.valueOf(number);
                break;
            case Symbols.DIVID_SYMBOL:
                result /= Integer.valueOf(number);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.ILLEGAL_ARGUMENT_EXCEPTION_MSG);
        }

        return result;

    }

    List<String> tokenize(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }

}
