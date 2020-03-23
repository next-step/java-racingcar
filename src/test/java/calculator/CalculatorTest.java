package calculator;

import calculator.exception.OperatorNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 2 - 1=2", "1 / 5 * 7=1.4", "3 - 9 / 2 * 7=-21"}, delimiter = '=')
    @DisplayName("복합 연산 테스트")
    void calculateTest(String input, double result) {
        Calculator calculator = new Calculator(input);
        assertThat(calculator.calculate()).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2=3", "2 + 7=9", "8 + 22 + 0=30"}, delimiter = '=')
    @DisplayName("더하기 테스트")
    void plusCalculateTest(String input, double result) {
        Calculator calculator = new Calculator(input);
        assertThat(calculator.calculate()).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 - 2=-1", "9 - 7=2", "11 - 11=0", "3 - 9 - 11=-17"}, delimiter = '=')
    @DisplayName("빼기 테스트")
    void minusCalculateTest(String input, double result) {
        Calculator calculator = new Calculator(input);
        assertThat(calculator.calculate()).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 * 2=2", "2 * 7=14", "8 * 22 * 1=176"}, delimiter = '=')
    @DisplayName("곱하기 테스트")
    void multiplyCalculateTest(String input, double result) {
        Calculator calculator = new Calculator(input);
        assertThat(calculator.calculate()).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 / 2=0.5", "8 / 2=4", "2 / 2 / 5=0.2"}, delimiter = '=')
    @DisplayName("나누기 테스트")
    void divisionCalculateTest(String input, double result) {
        Calculator calculator = new Calculator(input);
        assertThat(calculator.calculate()).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("잘못된 수식일때 IllegalArgumentException 테스트")
    @ValueSource(strings = {"1 $ 2 - 3", "1 / 2 # 3", "1 ! 2 @ 3", "1 > 2"})
    void validateInvalidFormulaTest(String input) {
        assertThatThrownBy(() -> {
                    Calculator calculator = new Calculator(input);
                }
        ).isInstanceOf(OperatorNotFoundException.class);
    }

    @ParameterizedTest
    @DisplayName("입력 값이 null이거나 빈 공백 문자일때 IllegalArgumentException 테스트")
    @MethodSource("blanks")
    void validateEmptyTest(String input) {
        assertThatThrownBy(() -> {
                    Calculator calculator = new Calculator(input);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<String> blanks() {
        return Stream.of("", "   ", null);
    }
}
