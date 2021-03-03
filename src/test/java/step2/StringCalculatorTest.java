package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * 문자열 사칙 연산 계산기 테스트
 */
class StringCalculatorTest {

    private static Stream<String> blankStrings() {
        return Stream.of(null, "", "  ");
    }

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @DisplayName("덧셈 테스트")
    @ParameterizedTest(name = "{0} 와 {1}을 더하기 테스트")
    @CsvSource(value = {"3,1", "4,2"})
    void plusOperatorTest(Integer a, Integer b) {
        int sum = calculator.plus(a, b);
        assertThat(sum).isEqualTo(a + b);
    }

    @DisplayName("뺄셈 테스트")
    @ParameterizedTest(name = "{0} 에서 {1}을 빼기 테스트")
    @CsvSource(value = {"3,1"})
    void subtractOperatorTest(Integer minuend, Integer subtrahend) {
        int result = calculator.subtract(minuend, subtrahend);
        assertThat(result).isEqualTo(minuend - subtrahend);
    }

    @DisplayName("곱하기 테스트")
    @ParameterizedTest(name = "{0} 와 {1}를 곱하는 테스트")
    @CsvSource(value = {"2,4"})
    void multiplyOperatorTest(Integer multiplicand, Integer multiplier) {
        int result = calculator.multiply(multiplicand, multiplier);
        assertThat(result).isEqualTo(multiplicand * multiplier);
    }

    @DisplayName("나누기 테스트")
    @ParameterizedTest(name = "{0} 에서 {1}를 나누는 테스트")
    @CsvSource(value = {"6,3"})
    void divideOperatorTest(Integer dividend, Integer divisor) {
        int result = calculator.divide(dividend, divisor);
        assertThat(result).isEqualTo(dividend / divisor);
    }

    @DisplayName("입력 값이 `null`이거나 `빈 공백` 문자인 경우 IllegalArgumentException throw")
    @ParameterizedTest(name = "입력 값이 `{0}` 인 경우 IllegalArgumentException throw")
    @MethodSource("blankStrings")
    void isBlank_ShouldReturnTrueForNullOrBlankStringsOneArgument(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.apply(input));
    }

    @DisplayName("사칙연산 기호가 아닌 경우의 예외처리 테스트")
    @ParameterizedTest(name = "입력된 문자열에 사칙연산 값이 아닌 `{0}` 경우 예외처리 테스트")
    @ValueSource(strings = {"!", "@", "#"})
    void testCase(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    calculator.apply(input);
                });
    }
}
