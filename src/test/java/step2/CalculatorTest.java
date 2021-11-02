package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @DisplayName("+ 기호가 있으면 덧셈을 한다.")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3:5", "3 + 4 + 6:13"}, delimiter = ':')
    void addTest(String input, int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @DisplayName("- 기호가 있으면 뺄셈을 한다.")
    @ParameterizedTest
    @CsvSource(value = {"3 - 3:0", "10 - 4 - 2:4"}, delimiter = ':')
    void subtractTest(String input, int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @DisplayName("* 기호가 있으면 곱셈을 한다.")
    @ParameterizedTest
    @CsvSource(value = {"3 * 3:9", "10 * 4 * 2:80"}, delimiter = ':')
    void multiplyTest(String input, int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @DisplayName("/ 기호가 있으면 나눗셈을 한다.")
    @ParameterizedTest
    @CsvSource(value = {"3 / 3:1", "20 / 2 / 2:5"}, delimiter = ':')
    void divisionTest(String input, int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @DisplayName("간단한 계산식을 통과 한다.")
    @ParameterizedTest
    @CsvSource(value = {"3 + 7 / 2 * 3:15", "20 / 2 - 5 * 2 + 100:110"}, delimiter = ':')
    void multiTest(String input, int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw")
    @ParameterizedTest
    @ValueSource(strings = {"   3 + 7", " ", "-"})
    void emptyStringTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(input));
    }

    @DisplayName("숫자 연산자가 잘못된 경우 IllegalArgumentException throw")
    @ParameterizedTest
    @ValueSource(strings = {"- 3 + 7", "4 k 8", "4   8"})
    void wrongStringTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(input));
    }

    @DisplayName("숫자 연산자가 잘못된 경우 IllegalArgumentException throw")
    @ParameterizedTest
    @NullAndEmptySource
    void nullStringTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(input));
    }
}