package calculator;

import calculator.exception.NotSupportedOperatorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    @Test
    @DisplayName("calculate 메소드는 문자열 수식을 계산한 결과를 반환한다")
    public void 테스트_calculate() {
        assertThat(Calculator.calculate("1 + 2")).isEqualTo(new MyNumber(3));
        assertThat(Calculator.calculate("3 - 2")).isEqualTo(new MyNumber(1));
        assertThat(Calculator.calculate("3 * 2")).isEqualTo(new MyNumber(6));
        assertThat(Calculator.calculate("4 / 2")).isEqualTo(new MyNumber(2));
    }

    @Test
    @DisplayName("calculate 메소드는 사칙 연산 기호가 아닌 수식인 경우 IllegalArgumentException가 발생한다.")
    public void 테스트_calculate_NotSupportedOperatorException() {
        assertThrows(NotSupportedOperatorException.class, () -> Calculator.calculate("1 & 2"));
    }

}
