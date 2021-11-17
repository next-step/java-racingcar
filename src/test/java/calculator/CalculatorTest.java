package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @DisplayName("+ 기호가 존재하는 경우, 덧셈 기능을 지원한다.")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "2 + 2:4", "1 + 3:4", "0 + 2:2"}, delimiter = ':')
    public void 덧셈(String input, int expected) {
        int actual = Calculator.calculate(input);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("- 기호가 존재하는 경우, 뺄셈 기능을 지원한다.")
    @ParameterizedTest
    @CsvSource(value = {"2 - 1:1", "3 - 2:1", "4 - 2:2", "2 - 0:2"}, delimiter = ':')
    public void 뺄셈(String input, int expected) {
        int actual = Calculator.calculate(input);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("* 기호가 존재하는 경우, 곱셈 기능을 지원한다.")
    @ParameterizedTest
    @CsvSource(value = {"1 * 1:1", "1 * 2:2", "2 * 2:4", "3 * 2:6"}, delimiter = ':')
    public void 곱셈(String input, int expected) {
        int actual = Calculator.calculate(input);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("/ 기호가 존재하는 경우, 나눗셈 기능을 지원한다.")
    @ParameterizedTest
    @CsvSource(value = {"1 / 1:1", "4 / 2:2", "6 / 2:3", "3 / 1:3"}, delimiter = ':')
    public void 나눗셈(String input, int expected) {
        int actual = Calculator.calculate(input);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("나눗셈의 분모가 0인 경우 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"4 / 0", "1 / 0"})
    public void 나눗셈(String input) {
        assertThatThrownBy(() -> {
            Calculator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("계산기에 null을 입력한 경우 exception을 발생한다.")
    @Test
    public void 값_null() {
        assertThatThrownBy(() -> {
            Calculator.calculate(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사칙 연산 기호가 아닌 경우 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"4 $ 2", "1 @ 1", "2 # 1"})
    public void isNotOperator(String input) {
        assertThatThrownBy(() -> {
            Calculator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사칙 연산을 모두 포함한 경우 연산을 수행한다.")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "4 - 1 / 1 * 2:6", "2 * 2 + 4 / 2:4"}, delimiter = ':')
    public void calculate(String input, int expected) {
        assertThat(Calculator.calculate(input)).isEqualTo(expected);
    }

}
