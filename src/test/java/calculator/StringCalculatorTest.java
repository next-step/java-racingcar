package calculator;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringCalculatorTest {

    @DisplayName("입력값이 null 예외처리")
    @Test
    void inputNullTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator calculator = new StringCalculator();
            calculator.setInput(null);
        });
    }

    @DisplayName("입력값이 공백 예외처")
    @Test
    void inputEmptyTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator calculator = new StringCalculator();
            calculator.setInput("");
        });
    }

    @DisplayName("4칙 연산 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3 * 4 / 2:10",
            "10 / 2 - 5:0",
            "10 * 2 - 3:17",
            "5 + 5 / 2 * 1:5" },
            delimiter = ':')
    void arithmeticTest(String testString, double result) {
        StringCalculator calculator = new StringCalculator();
        calculator.setInput(testString);
        assertThat(calculator.calculate()).isEqualTo(result);
    }
}
