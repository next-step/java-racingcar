package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperationTest {

    @DisplayName("덧셈 계산을 수행한다")
    @ParameterizedTest
    @CsvSource(value = {"11 + 22:33", "21 + 22:43", "-1 + 2:1"}, delimiter = ':')
    public void additionTest(String inputExpression, double expectedResult) {
        double result = StringCalculator.runCalculator(inputExpression);
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("뺄셈 계산을 수행한다")
    @ParameterizedTest
    @CsvSource(value = {"1 - 2:-1", "2 - 2:0", "3 - 1:2"}, delimiter = ':')
    public void subtractionTest(String inputExpression, double expectedResult) {
        double result = StringCalculator.runCalculator(inputExpression);
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("곱셈 계산을 수행한다")
    @ParameterizedTest
    @CsvSource(value = {"1 * 2:2", "2 * -2:-4", "-1 * -1:1"}, delimiter = ':')
    public void multiplicationTest(String inputExpression, double expectedResult) {
        double result = StringCalculator.runCalculator(inputExpression);
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("나눗셈 계산을 수행한다")
    @ParameterizedTest
    @CsvSource(value = {"1 / 2:0", "2 / 2:1"}, delimiter = ':')
    public void divisionTest(String inputExpression, double expectedResult) {
        double result = StringCalculator.runCalculator(inputExpression);
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("사칙연산 기호가 아닌경우 예외를 발생시킨다")
    @ParameterizedTest
    @ValueSource(strings = {"1 ! 2", "1 @ 3", "1 1 1"})
    public void notOperationTest(String inputExpression) {
        assertThatThrownBy(() -> StringCalculator.runCalculator(inputExpression)).isInstanceOf(IllegalArgumentException.class);
    }

}
