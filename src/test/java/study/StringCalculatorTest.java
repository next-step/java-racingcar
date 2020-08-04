package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @ParameterizedTest
    @DisplayName("사칙연산 - 덧셈")
    @CsvSource(value = {"3:5:8", "1:4:5"}, delimiter = ':')
    void additionTest(int prev, int next, int result) {
        assertThat(Operator.ADDITION.compute(prev, next)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("사칙연산 - 뺄셈")
    @CsvSource(value = {"10:5:5", "4:2:2"}, delimiter = ':')
    void subtractionTest(int prev, int next, int result) {
        assertThat(Operator.SUBTRACTION.compute(prev, next)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("사칙연산 - 곱셈")
    @CsvSource(value = {"1:5:5", "4:4:16"}, delimiter = ':')
    void multipleTest(int prev, int next, int result) {
        assertThat(Operator.MULTIPLICATION.compute(prev, next)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("사칙연산 - 나눗셈")
    @CsvSource(value = {"6:2:3", "9:3:3"}, delimiter = ':')
    void devisionTest(int prev, int next, int result) {
        assertThat(Operator.DIVISION.compute(prev, next)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("입력값이 null이거나 공백인 경우")
    @NullSource
    @EmptySource
    void calculateTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator calculator = new StringCalculator(input);
        });
    }

    @ParameterizedTest
    @DisplayName("사칙연산의 기호가 아닌 경우")
    @ValueSource(strings = {"3 ^", "11 $"})
    void notOperater(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator calculator = new StringCalculator(input);
            calculator.calculate();
        });
    }

    @ParameterizedTest
    @DisplayName("사칙연산 통합 테스트")
    @ValueSource(strings = {"2 + 3 * 4 / 2", "3 + 3 - 1 * 4 / 10"})
    void totalTest(String input) {
        StringCalculator calculator = new StringCalculator(input);
        calculator.calculate();
    }
}
