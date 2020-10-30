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

    @DisplayName("올바르지 않은 연산자를 포함한 입력에 대한 테스트")
    @ValueSource(strings = {"1 & 3 * 2", "1 % 3 * 4"})
    @ParameterizedTest
    void containInvalidOperator(String input) {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(
                        () -> {
                            Calculator calculator = Calculator.Of(input);
                            calculator.calculate();
                        }
                );
    }

    @DisplayName("짝이 맞지 않는 식에 대한 테스트")
    @ValueSource(strings = {"1 + 2 + ", "3 * 4 /"})
    @ParameterizedTest
    void unmatchedOperator(String input) {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(
                        () -> {
                            Calculator calculator = Calculator.Of(input);
                            calculator.calculate();
                        }
                );
    }

}