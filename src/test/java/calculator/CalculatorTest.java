package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @DisplayName("3을 넣었을 때는 에러가 아니라 0+3개념으로 나오는지")
    @Test
    void name1() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate("3");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("상황별로 결과값이 맞게 나오는지")
    @ParameterizedTest
    @CsvSource({"3 + 2, 5", "3 - 2, 1", "3 * 2 + 4 / 2 - 3, 2", "3 / 2 + 4 - 2 * 3, 9"})
    void situationTest(String sentence, int expected) {
        Calculator calculator = new Calculator();
        int result = calculator.calculate(sentence);
        assertThat(result).isEqualTo(expected);
    }
}
