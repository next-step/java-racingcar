package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {
        "1,1",
        "1 + 2,3", "4 - 2,2", "3 * 4,12", "20 / 5,4",
        "2 + 3 * 4 / 2,10",
        "1 + 2 - 3 * 5 / 1,0"
    })
    @DisplayName("정상적인 input 에 대한 결과 출력")
    public void calculator_normal_equalToResult(String input, int result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @Test
    @DisplayName("null 혹은 empty input 시 예외 출력")
    public void calculator_NullOrEmptyInput_ExceptionThrown() {
        expectIllegalArgumentException(null);
        expectIllegalArgumentException("");
        expectIllegalArgumentException(" ");
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "1 ^", "1 / 2 / 3 *"
    })
    @DisplayName("잘못된 input에 대한 예외 출력")
    public void calculator_InvalidInput_ExceptionThrown(String input) {
        expectIllegalArgumentException(input);
    }

    private void expectIllegalArgumentException(String input) {
        assertThatThrownBy(() -> calculator.calculate(input)).isInstanceOf(IllegalArgumentException.class);
    }

}
