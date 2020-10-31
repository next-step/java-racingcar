package study.step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @DisplayName("null/empty string 입력시 예외가 발생한다.")
    @NullAndEmptySource
    void nullAndEmptyInput(String input) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class) //
                .isThrownBy(() -> new Calculator(input).calculate()) //
                .withMessage("계산식이 존재하지 않습니다.");
    }

    @ParameterizedTest
    @DisplayName("'+' 연산 테스트")
    @CsvSource({"0 + 1,1", "1 + 1,2", "10 + 10,20", "123 + 32,155", // 여러 자릿수
            "1 + 1,2", "1 + 1 + 1,3", "1 + 1 + 1 + 1,4", "2 + 3 + 5 + 7 + 11,28" // 여러 수
    })
    void plusTest(String input, long expectResult) {
        assertThat(new Calculator(input).calculate()).isEqualTo(expectResult);
    }

    @ParameterizedTest
    @DisplayName("연산자 사이에 빈공간이 없는 경우")
    @ValueSource(strings = {"1+1", "1 + 1+1", "1 + 1+1 + 1"})
    void noSpaceBetweenSignAndNumbers(String input) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class) //
                .isThrownBy(() -> new Calculator(input).calculate()) //
                .withMessage("연산자 사이에는 빈 공간이 한칸 있어야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("'-' 연산 테스트")
    @CsvSource({"1 - 0,1", "1 - 1,0", "20 - 10,10", "123 - 32,91", // 여러 자릿수
            "1 - 0,1", "3 - 1 - 1,1", "10 - 1 - 2 - 3,4" // 여러 수
    })
    void minusTest(String input, long expectResult) {
        assertThat(new Calculator(input).calculate()).isEqualTo(expectResult);
    }

    @ParameterizedTest
    @DisplayName("'*' 연산 테스트")
    @CsvSource({"1 * 0,0", "1 * 1,1", "2 * 1,2", "123 * 32,3936", // 여러 자릿수
            "1 * 0,0", "1 * 2 * 3,6", "10 * 20 * 300 * 0,0" // 여러 수
    })
    void multiplyTest(String input, long expectResult) {
        assertThat(new Calculator(input).calculate()).isEqualTo(expectResult);
    }

    @ParameterizedTest
    @DisplayName("'/' 연산 테스트")
    @CsvSource({"0 / 1,0", "1 / 1,1", "2 / 1,2", "144 / 12,12", // 여러 자릿수
            "0 / 1,0", "10 / 2 / 5,1", "300 / 3 / 10,10" // 여러 수
    })
    void divisionTest(String input, long expectResult) {
        assertThat(new Calculator(input).calculate()).isEqualTo(expectResult);
    }

    @Test
    @DisplayName("'/' 연산 에서 정수로 떨어지지 않는 경우 예외처리")
    void divideResultNotIntegerException() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class) //
                .isThrownBy(() -> new Calculator("3 / 2").calculate()) //
                .withMessage("나눗셈은 정수로 떨어져야 합니다.");
    }

    @Test
    @DisplayName("0으로 나누는 예외 확인")
    void dividedByZeroException() {
        Assertions.assertThatExceptionOfType(ArithmeticException.class) //
                .isThrownBy(() -> new Calculator("1 / 0").calculate()) //
                .withMessage("/ by zero");
    }

    @Test
    @DisplayName("사칙연산 연산자가 아닌경우 예외처리")
    void invalidOperator() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class) //
                .isThrownBy(() -> new Calculator("3 ~ 2").calculate()) //
                .withMessage("올바른 연산자가 아닙니다.");
    }

    @Test
    @DisplayName("여러 연산이 같이 있는 경우 앞쪽 연산부터 수행한다")
    void complexTest() {
        assertThat(new Calculator("2 + 3 * 4 / 2").calculate()).isEqualTo(10);
    }

}

