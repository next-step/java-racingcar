package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {

    @DisplayName("연산식 계산 테스트")
    @ParameterizedTest
    @CsvSource({"1 + 10 / 3, 3", "10 / 4 * 2 + 1 - 4, 1"})
    void execute(String input, int result) {
        StringCalculator calculator = new StringCalculator(input);
        assertEquals(calculator.execute(), result);
    }
}
