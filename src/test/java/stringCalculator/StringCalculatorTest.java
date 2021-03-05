package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @DisplayName("문자열 계산을 수행한다")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "2 * 2:4", "3 - 1:2", "4 / 2:2"}, delimiter = ':')
    public void calculateTest(String inputExpression, double expectedResult) {
        double result = StringCalculator.runCalculator(inputExpression);
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("빈 문자열을 입력하면 예외를 발생시킨다")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    public void emptyStringTest(String inputExpression) {
        assertThatThrownBy(() -> StringCalculator.runCalculator(inputExpression)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Null을 입력하면 예외를 발생시킨다")
    @Test
    public void nullTest() {
        assertThatThrownBy(() -> StringCalculator.runCalculator(null)).isInstanceOf(IllegalArgumentException.class);
    }
}
