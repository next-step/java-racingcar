package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step2.Operator.*;

/**
 * 연산자 상태 및 행위
 */
class OperatorTest {

    @DisplayName("연산자: PLUS 연산 테스트")
    @ParameterizedTest(name = "{0} + {1} = {2} 연산 테스트")
    @CsvSource(value = {"3, 1, 4"})
    void plusTest(Integer a, Integer b, Integer expected) {
        Integer sum = PLUS.calculate(a, b);
        assertThat(sum).isEqualTo(expected);
    }

    @DisplayName("연산자: SUBTRACT 연산 테스트")
    @ParameterizedTest(name = "{0} - {1} = {2} 연산 테스트")
    @CsvSource(value = {"5, 3, 2"})
    void subtractTest(Integer minuend, Integer subtrahend, Integer expected) {
        Integer result = SUBTRACT.calculate(minuend, subtrahend);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("연산자: MULTIPLY 연산 테스트")
    @ParameterizedTest(name = "{0} * {1} = {2} 연산 테스트")
    @CsvSource(value = {"5, 2, 10"})
    void multiplyTest(Integer multiplicand, Integer multiplier, Integer expected) {
        Integer result = MULTIPLY.calculate(multiplicand, multiplier);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("연산자: DIVIDE 연산 테스트")
    @ParameterizedTest(name = "{0} / {1} = {2} 연산 테스트")
    @CsvSource(value = {"7, 3, 2"})
    void divideTest(Integer dividend, Integer divisor, Integer expected) {
        Integer result = DIVIDE.calculate(dividend, divisor);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("연산자: DIVIDE 연산 0을 나눌때 예외처리 테스트")
    @ParameterizedTest(name = "{0} / {1} = {2} 연산 테스트")
    @CsvSource(value = {"0, 3, 2"})
    void divide_DivideByZeroException(Integer dividend, Integer divisor, Integer expected) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    DIVIDE.calculate(dividend, divisor);
                });
    }

    @DisplayName("연산자: 사칙 연산 체크 테스트")
    @ParameterizedTest(name = "{0} 입력 시 {1}")
    @CsvSource(value = {"^, false", "+, true"})
    void isOperation_ValidationFourOperationCalculation(String given, boolean expected) {
        boolean operation = isOperation(given);
        assertThat(operation).isEqualTo(expected);
    }
}
