package calculator;

import calculator.exception.NotSupportedOperatorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "3 - 2:1", "3 * 2:6", "4 / 2:2"}, delimiter = ':')
    @DisplayName("calculate 메소드는 문자열 수식을 계산한 결과를 반환한다")
    public void 테스트_calculate(String formula, int result) {
        assertThat(Calculator.calculate(formula)).isEqualTo(new MyNumber(result));
    }

    @Test
    @DisplayName("calculate 메소드는 사칙 연산 기호가 아닌 수식인 경우 IllegalArgumentException가 발생한다.")
    public void 테스트_calculate_NotSupportedOperatorException() {
        assertThrows(NotSupportedOperatorException.class, () -> Calculator.calculate("1 & 2"));
    }

}
