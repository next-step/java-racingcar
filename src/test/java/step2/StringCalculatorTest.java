package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 문자열 사칙 연산 계산기 테스트
 */
class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @DisplayName("덧셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3,1"}, delimiter = ',')
    void plusOperatorTest(Integer a, Integer b) {
        int sum = calculator.plus(a, b);
        assertThat(sum).isEqualTo(a + b);
    }

    @DisplayName("뺄셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3,1"}, delimiter = ',')
    void subtractOperatorTest(Integer minuend, Integer subtrahend) {
        int result = calculator.subtract(minuend, subtrahend);
        assertThat(result).isEqualTo(minuend - subtrahend);
    }
}
