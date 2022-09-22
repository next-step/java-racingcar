package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"-0", "1,2-3", "1,2,3-6"}, delimiter = '-')
    @DisplayName("쉼표(,)를 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.")
    void add_ShouldReturnSumDelimitByComma(String input, String expected) {
        // given - when
        int actual = calculator.add(input);

        // then
        assertThat(actual).isEqualTo(Integer.parseInt(expected));
    }

    @Test
    @DisplayName("콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.")
    void add_ShouldReturnSumDelimitByColon() {
        // given
        String input = "1:2:3";
        int expected = 6;

        // when
        int actual = calculator.add(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"//;\\n1;2;3", "//a\\n1;2;3"}, delimiter = '-')
    @DisplayName("커스텀 구분자를 포함한 문자열을 전달하는 경우 해당 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.")
    void add_ShouldReturnSumWithCustomizedDelimiter(String input, String expected) {
        // given - when
        int actual = calculator.add(input);

        // then
        assertThat(actual).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @DisplayName("문자열 계산기에 숫자 이외의 값을 전달하는 경우 RuntimeException 예외를 throw한다.")
    void add_ShouldThrowExceptionWhenNegativeNumberInput() {
        // given
        String input = "ㄱ,1";

        // when - then
        assertThatThrownBy(() -> calculator.add(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("");
    }

    @ParameterizedTest
    @DisplayName("문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외를 throw한다.")
    void add_ShouldThrowExceptionWhenNonNumberInput() {
        // given
        String input = "-1,-2";

        // when - then
        assertThatThrownBy(() -> calculator.add(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("");
    }
}
