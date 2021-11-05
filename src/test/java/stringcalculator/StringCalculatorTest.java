package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @DisplayName("plus test")
    @CsvSource({"1 + 2, 3", "2 + 2, 4"})
    void plusTest(String s, int expected) {
        int actual = stringCalculator.calc(s);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("minus test")
    @CsvSource({"1 - 2, -1", "2 - 2, 0", "3 - 2, 1"})
    void minusTest(String s, int expected) {
        int actual = stringCalculator.calc(s);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("multiply test")
    @CsvSource({"1 * 2, 2", "2 * 2, 4", "3 * -2, -6"})
    void multiplyTest(String s, int expected) {
        int actual = stringCalculator.calc(s);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("divide test")
    @CsvSource({"2 / 1, 2", "2 / 2, 1", "6 / 3, 2"})
    void divideTest(String s, int expected) {
        int actual = stringCalculator.calc(s);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("사칙 연산 테스트")
    @CsvSource({"2 + 1 - 1, 2", "2 / 2 + 3 * 2, 8", "6 - 3 + 1 * 2 / 2, 4"})
    void calcTest(String s, int expected) {
        assertThat(stringCalculator.calc(s)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("연산자 예외")
    @ValueSource(strings = {"1 { 1", "2 [ 2", "3 ^ 3", "1 $ 2"})
    void operatorException(String s) {
        assertThatThrownBy(() -> stringCalculator.calc(s)).isInstanceOf(NotFoundOperatorException.class);
    }

    @ParameterizedTest
    @DisplayName("NumberException test")
    @ValueSource(strings = {"k + k", "c - c", "t * t"})
    void numberExceptionTest(String s) {
           assertThatThrownBy(() -> stringCalculator.calc(s)).isInstanceOf(IllegalArgumentException.class);
    }

}