package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@DisplayName("계산")
class CalculatorTest {
    @Test
    void 숫자로형변환이안되면_NumberFormatException() {
        String input = "t";
        assertThatThrownBy(() -> {
            Calculator.convertStringToDouble(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("연산하기위해 숫자를 입력해주세요.");
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2=10", "2 * 12=24", "1 + 2 - 4=-1", "8 / 2 + 3 * 6 - 1=41"}, delimiter = '=')
    void 사칙_연산을_모두_포함하는_기능(String input, int result) {
        assertThat(new Calculator(input).runCalculator()).isEqualTo(result);
    }
}