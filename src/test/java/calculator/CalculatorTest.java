package calculator;

import calculator.domain.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @DisplayName("사칙연산 기능 테스트")
    @ParameterizedTest
    @CsvSource({"+,9", "-,3", "*,18", "/,2"})
    public void calculate(String symbol, long expected) {
        assertThat(Calculator.calculate(6, 3, symbol)).isEqualTo(expected);
    }

}
