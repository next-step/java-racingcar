package calculator;

import caculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    @DisplayName("덧셈을 테스트")
    void testAddition() {
        double actual = calculator.calculate("5 + 4");
        assertThat(actual).isEqualTo(9);
    }

    @Test
    @DisplayName("뺄셈을 테스트")
    void testSubtraction() {
        double actual = calculator.calculate("5 - 2");
        assertThat(actual).isEqualTo(3);
    }

    @Test
    @DisplayName("곱셈을 테스트")
    void testMultiply() {
        double actual = calculator.calculate("5 * 4");
        assertThat(actual).isEqualTo(20);
    }

    @Test
    @DisplayName("나눗셈을 테스트")
    void testDivision() {
        double actual = calculator.calculate("60 / 5");
        assertThat(actual).isEqualTo(12);
    }

    @ParameterizedTest
    @DisplayName("모든 사칙 연산 테스트")
    @MethodSource("provideOperationForCalculationLogic")
    void testAllOperator(double expected, String expression) {
        double actual = calculator.calculate(expression);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideOperationForCalculationLogic() {
        return Stream.of(
                Arguments.of(7, "10 * 2 / 5 - 3 + 6"),
                Arguments.of(26, "50 * 4 / 8 - 6 + 7"),
                Arguments.of(-2, "4 + 2 + 5 - 12 * 6 / 3")
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException")
    void testExpectedExceptionNullOrEmpty(String input) {
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사칙 연산 기호가 아닌 경우 IllegalArgumentException")
    void testExpectedExceptionArithmeticOperation() {
        assertThatThrownBy(() -> calculator.calculate("3 + 4 & 7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 아닌 경우 IllegalArgumentException")
    void testExpectedExceptionNumber() {
        assertThatThrownBy(() -> calculator.calculate("& 5 4 & 7"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
