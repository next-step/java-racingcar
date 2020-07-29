import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("두 개의 숫자를 입력 받아 덧셈")
    void plusBiOperand() {
        String input = "1 + 2";
        int plus = calculator.plus(input);

        assertThat(plus).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2 + 3:6", "1 + 2 + 3 + 4 + 5:15"}, delimiter = ':')
    @DisplayName("여러 개의 숫자를 입력 받아 덧셈")
    void plusTest(String input, int result) {
        int plus = calculator.plus(input);

        assertThat(plus).isEqualTo(result);

    }
}