package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("계산기가 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw하는지 테스트")
    void checkInputNullOrEmptyString(String input) {
        assertThatThrownBy(() -> {
            calculator.result(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 3 4 / 2", "2  3", "/ 2 3"})
    @DisplayName("숫자 사칙연산기호 숫자 사칙연산기호 숫자 형태가 아니면 IllegalArgumentException throw하는지 테스트")
    void checkInputFormat(String input) {
        assertThatThrownBy(() -> {
            calculator.result(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "3 + 1:4", "3 + 1 +:4"}, delimiter = ':')
    @DisplayName("덧셈 테스트")
    void add(String input, int result) {
        assertThat(calculator.result(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 - 1:1", "3 - 1:2", "3 - 1 -:2"}, delimiter = ':')
    @DisplayName("뺄셈 테스트")
    void subtraction(String input, int result) {
        assertThat(calculator.result(input)).isEqualTo(result);
    }
}
