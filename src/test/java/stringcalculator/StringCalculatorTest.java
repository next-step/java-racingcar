package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1 + 2=3",
            "2 - 1=1",
            "1 * 3=3",
            "4 / 2=2"
    }, delimiter = '=')
    @DisplayName("Operator 검증")
    public void calculator_success(String input, int result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @Test
    @DisplayName("유효하지 않은 연산 기호")
    public void calculate_fail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.calculate("3 + 4 % 7"));
    }

    @Test
    @DisplayName("유효하지 않은 수식")
    public void calculate_fail_null() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.calculate(null));
    }
}
