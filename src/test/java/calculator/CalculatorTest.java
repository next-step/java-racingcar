package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@DisplayName("계산")
class CalculatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"2", "#"})
    void 연산자연산기호가아닌경우_IllegalArgumentException(String operation) {
        assertThatThrownBy(() -> {
            Calculator.checkOperationSign(operation);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 잘못되었습니다. 사칙연산부호를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void 입력_값이_null이거나_빈_공백_문자일_경우_IllegalArgumentException(String input) {
        assertThatThrownBy(() -> {
            Calculator.checkBlack(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("값을 입력해주세요.");
    }

    @Test
    void 숫자로형변환이안되면_NumberFormatException() {
        String input = "t";
        assertThatThrownBy(() -> {
            Calculator.convertStringToInt(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("연산하기위해 숫자를 입력해주세요.");
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2=10", "2 * 12=24", "1 + 2 - 4=-1", "8 / 2 + 3 * 6 - 1=41"}, delimiter = '=')
    void 사칙_연산을_모두_포함하는_기능(String input, int result) {
        assertThat(Calculator.runCalculator(input)).isEqualTo(result);
    }
}