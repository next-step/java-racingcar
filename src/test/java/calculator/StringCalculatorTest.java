package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {

    private StringCalculator calculator = new StringCalculator();

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @ParameterizedTest
    @DisplayName("문자열 계산기 테스트")
    @CsvSource(value = {
            "2 + 3 * 4 / 2=10",
            "2 + 3 - 4 * 5 / 2=2",
            "7 + 5 * 9 / 6=18",
            "9 + 6 * 3 / 5 + 1=10",
            "7 + 7 * 4 / 8=7",
    }, delimiter = '=')
    void string_calculate_test(String text, int expected) {
        assertEquals(expected, calculator.calculate(text));
    }
}
