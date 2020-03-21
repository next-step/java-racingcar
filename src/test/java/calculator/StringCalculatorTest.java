package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @DisplayName(value = "숫자 두개에 덧셈(+)을 입력할 경우 두 숫자의 합을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"4 + 2"})
    void plus(final String textInput) {
        assertThat(calculator.calculate(textInput)).isEqualTo(6);
    }

    @DisplayName(value = "숫자 두개에 뺄셈(-)을 입력할 경우 두 숫자의 차를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"4 - 2"})
    void minus(final String textInput) {
        assertThat(calculator.calculate(textInput)).isEqualTo(2);
    }

    @DisplayName(value = "숫자 두개에 곱셈(*)을 입력할 경우 두 숫자의 곱을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"4 * 2"})
    void multiply(final String textInput) {
        assertThat(calculator.calculate(textInput)).isEqualTo(8);
    }

    @DisplayName(value = "숫자 두개에 나눗셈(/)을 입력할 경우 두 숫자의 나눈값을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"4 / 2"})
    void divide(final String textInput) {
        assertThat(calculator.calculate(textInput)).isEqualTo(2);
    }

    @DisplayName(value = "복합적으로 들어있는 수식의 결과를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    void calculateAll(final String textInput) {
        assertThat(calculator.calculate(textInput)).isEqualTo(10);
    }

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 IllegalArgumentException 이 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyOrNull(final String textInput) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculate(textInput));
    }

    @DisplayName(value = "사칙연산 기호가 아닌 경우 IllegalArgumentException 이 발생")
    @ParameterizedTest
    @ValueSource(strings = {"2 ? 3", "2 & 3"})
    void symbol(final String textInput) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculate(textInput));
    }
}
