package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("문자열 사칙 연산 계산기: 덧셈 테스트")
    void plusOperatorTest() {
        int sum = calculator.plus(3, 1);
        assertThat(sum).isEqualTo(4);
    }
}
