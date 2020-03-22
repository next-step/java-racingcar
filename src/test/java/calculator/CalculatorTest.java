package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {

    @DisplayName("더하기")
    @ParameterizedTest
    @CsvSource({"2 + 3, 5", "3 + 2, 5", "1 + 0, 1"})
    void add(String str, double expected) {
        assertThat(Calculator.calculate(str)).isEqualTo(expected);
    }

    @DisplayName("빼기")
    @ParameterizedTest
    @CsvSource({"2 - 3, -1", "3 - 2, 1", "1 - 0, 1"})
    void minus(String str, double expected) {
        assertThat(Calculator.calculate(str)).isEqualTo(expected);
    }

    @DisplayName("곱하기")
    @ParameterizedTest
    @CsvSource({"2 * 3, 6", "3 * -2, -6", "1 * 0, 0"})
    void multiply(String str, double expected) {
        assertThat(Calculator.calculate(str)).isEqualTo(expected);
    }

    @DisplayName("나누기")
    @ParameterizedTest
    @CsvSource({"6 / 3, 2", "4 / -2, -2", "1 / 1, 1"})
    void divide(String str, double expected) {
        assertThat(Calculator.calculate(str)).isEqualTo(expected);
    }

    @DisplayName("0으로 나눌 때 에러")
    @ParameterizedTest
    @CsvSource({"1 / 0"})
    void divideZeroError(String str) {
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calculate(str));
    }

    @DisplayName("유효하지 않은 계산식")
    @ParameterizedTest
    @CsvSource({"1 ( 0", "1 @ 2", "1 2 3", "- - 1", "1 + 3 +"})
    void invalidOperator(String str) {
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calculate(str));
    }

    @DisplayName("삼항 이상 계산")
    @ParameterizedTest
    @CsvSource({"1 + 2 * 2 / 3 - 2, 0", "2 * 6 * 3 / 3 + 3 - 2, 13"})
    void test(String str, double expected) {
        assertThat(Calculator.calculate(str)).isEqualTo(expected);
    }
}
