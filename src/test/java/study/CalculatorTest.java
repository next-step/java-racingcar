package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <pre>## stage2 요구사항
 *
 * * 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
 * * 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
 * * 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
 * * 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
 * * 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.</pre>
 */
public class CalculatorTest {

    private static final String SPACE = " ";
    private static final int OPERATOR_LENGTH = 1;

    private static final int LHS = 0;
    private static final int OPERATOR = 1;
    private static final int RHS = 2;

    private static final int REMAIN = 3;

    @ParameterizedTest
    @DisplayName("null/empty string 입력시 예외가 발생한다.")
    @NullAndEmptySource
    void nullAndEmptyInput(String input) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class) //
                .isThrownBy(() -> calculate(input));
    }

    @ParameterizedTest
    @DisplayName("여러 자릿수에 다한 '+' 연산 테스트")
    @CsvSource({"0 + 1,1", "1 + 1,2", "10 + 10,20", "123 + 32,155"})
    void plusTest(String input, long expectResult) {
        assertThat(calculate(input)).isEqualTo(expectResult);
    }

    @ParameterizedTest
    @DisplayName("여러 수에 다한 '+' 연산 테스트")
    @CsvSource({"1 + 1,2", "1 + 1 + 1,3", "1 + 1 + 1 + 1,4", "2 + 3 + 5 + 7 + 11,28"})
    void multiEquations(String input, long expectResult) {
        assertThat(calculate(input)).isEqualTo(expectResult);
    }

    @ParameterizedTest
    @DisplayName("연산자 사이에 빈공간이 없는 경우")
    @ValueSource(strings = {"1+1", "1 + 1+1", "1 + 1+1 + 1"})
    void noSpaceBetweenLettersAndNumbers(String input) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class) //
                .isThrownBy(() -> calculate(input)) //
                .withMessage("연산자 사이에는 빈 공간이 한칸 있어야 합니다.");
    }

    private long calculate(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException();
        }

        List<String[]> parsingResult = new ArrayList<>();

        do {
            String[] parsed = parse(input);
            parsingResult.add(new String[]{parsed[LHS], parsed[OPERATOR], parsed[RHS]});
            input = parsed[REMAIN];
        } while (!Objects.isNull(input));

        long result = 0;
        for (String[] parsed : parsingResult) {
            long lhs = result;
            if (!parsed[LHS].isEmpty()) {
                lhs = Long.parseLong(parsed[LHS]);
            }

            if (parsed[OPERATOR].equals("+")) {
                result = lhs + Long.parseLong(parsed[RHS]);
            }
        }
        return result;
    }

    private String[] parse(String input) {
        try {
            String lhs = input.substring(0, input.indexOf(SPACE));
            String operator = input.substring(lhs.length() + SPACE.length(), lhs.length() + SPACE.length() + OPERATOR_LENGTH);
            String rhs = input.substring(input.indexOf(operator) + OPERATOR_LENGTH + SPACE.length());
            String remain = null;

            String tmp = rhs;
            if (!isNumber(rhs)) {
                rhs = tmp.substring(0, tmp.indexOf(SPACE));
                remain = tmp.substring(rhs.length());
            }

            return new String[]{lhs, operator, rhs, remain};
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("연산자 사이에는 빈 공간이 한칸 있어야 합니다.");
        }
    }

    private boolean isNumber(String input) {
        return Pattern.matches("\\d+", input);
    }
}
