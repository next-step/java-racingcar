package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @DisplayName("단일 연산 수행")
    @ParameterizedTest
    @ValueSource(strings = {"2 * 3", "3 + 3"})
    void singleCalculate(String expression) {
        double actual = Calculator.calculate(expression);
        assertThat(actual).isEqualTo(6);
    }

    @DisplayName("복잡 연산 수행")
    @ParameterizedTest
    @ValueSource(strings = {"2 * 3 / 6", "9 / 3 / 3 * 1"})
    void multipleCalculate(String expression) {
        double actual = Calculator.calculate(expression);
        assertThat(actual).isEqualTo(1);
    }

    @DisplayName("0으로 나누기 테스트")
    @Test
    void divisionZero() {
        String expression = "3 + 10 * 3 / 0";
        assertThrows(IllegalArgumentException.class, () -> {
            Calculator.calculate(expression);
        });
    }
}