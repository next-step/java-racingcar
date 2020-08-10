package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @DisplayName("덧셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3 + 4:7", "2 + 5 + 8:15", "3 + 5 + 2:10"}, delimiter = ':')
    void plus(String input, int result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @DisplayName("뺄셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3 - 2:1", "5 - 2 - 3 - 1:-1"}, delimiter = ':')
    void minus(String input, int result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @DisplayName("곱셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3 * 2:6", "4 * 2 * 30:240"}, delimiter = ':')
    void multiply(String input, int result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @DisplayName("나눗셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3 / 2:1", "120 / 5 / 7:3"}, delimiter = ':')
    void division(String input, int result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @DisplayName("입력 값이 빈 공백 문자일 경우 테스트")
    @ParameterizedTest
    @EmptySource
    void isEmpty(String input) {
        assertThatThrownBy(() -> {
            calculator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 값이 null일 경우 테스트")
    @ParameterizedTest
    @NullSource
    void isNull(String input) {
        assertThatThrownBy(() -> {
            calculator.calculate(input);
        }).isInstanceOf(NullPointerException.class);
    }

    @DisplayName("사칙연산 기호가 아닌 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"3 + 2 & 7", "3 ) 2"})
    void operationError(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate(input);
        });
    }

    @DisplayName("사칙 연산을 모두 포함할 경우 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3 + 2 - 7 * 5 / 3:-3", "100 * 3 - 4 + 7 / 9:33"}, delimiter = ':')
    void allOperation(String input, int result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }
}
