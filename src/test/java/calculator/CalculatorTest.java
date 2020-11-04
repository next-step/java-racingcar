package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("calculate() 테스트 케이스")
    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(value = {
            // input, expectedResult
            "   2 + 3 * 4 / 2 | 10 ",
            "   5 * 7 + 3 + 2 | 40 ",
            "   6 / 2 + 3 * 7 | 42 ",
            " 16 * 51 * 7 / 4 | 1428 ",
    }, delimiter = '|')
    void calculator(String input, int expectedResult) {
        assertThat(calculator.calculate(input))
                .isEqualTo(expectedResult);
    }
}
