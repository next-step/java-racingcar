package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @DisplayName("입력 값이 null일 경우 IllegalArgumentException throw")
    @Test
    void inputNullTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.calculate(null);
        }).withMessageMatching(CalculatorMessage.INPUT_NULL);
    }

    @DisplayName("입력 값이 빈 공백 문자일 경우 IllegalArgumentException throw")
    @Test
    void inputBlankTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.calculate("");
        }).withMessageMatching(CalculatorMessage.INPUT_BLANK);
    }

    @DisplayName("기능 요구사항의 2 + 3 * 4 / 2 결과값으로 10이 나오는지 확인한다")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2=10", "4 / 2 + 10 - 5 + 1=8"}, delimiter = '=')
    void stringCalculatorTest(String input, long expected) {
        long result = StringCalculator.calculate(input);
        assertEquals(result, expected);
    }
}
