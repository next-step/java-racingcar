package study.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("정상적인 식을 테스트 한다.")
    @ParameterizedTest
    @CsvSource(value={"1 + 1=2", "3 - 1=2", "6 / 3=2", "3 * 7=21", "2 + 3 * 4 / 2=10"}, delimiter = '=')
    void validFormula(String formula, Integer expect) {
        assertThat(calculator.calculate(formula)).isEqualTo(expect);
    }

    @DisplayName("비정상적인 식을 테스트 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1 + ", " ", "/ / /", "1 2 3", "45 ? 50", "* / 3"})
    void invalidFormula(String formula) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            calculator.calculate(formula);
        });
    }
}
