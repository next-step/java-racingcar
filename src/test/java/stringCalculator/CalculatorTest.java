package stringCalculator;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {

    @DisplayName("일반적인 상황에서의 동작 테스트")
    @CsvSource(value = {"1 + 2 * 3 - 3 / 2:3", "3 * 3:9"}, delimiter = ':')
    @ParameterizedTest
    void onHappyPath(String input, int expected) {
        Calculator calculator = Calculator.Of(input);

        int actual = calculator.calculate();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("단일 항에 대한 동작 테스트")
    @CsvSource(value = {"10:10", "-3:-3", "0:0"}, delimiter = ':')
    @ParameterizedTest
    void onSingleValue(String input, int expected) {
        Calculator calculator = Calculator.Of(input);

        int actual = calculator.calculate();

        assertThat(actual).isEqualTo(expected);
    }

}
