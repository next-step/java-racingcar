package calculator;

import calculator.TextCalculator.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author han
 */
class TextCalculatorTest {

    TextCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new TextCalculator();
    }

    @ParameterizedTest(name = "덧셈")
    @CsvSource(value = {"2 + 2=4", "2 + 2 + 2 + 2=8", "1 + 2 + 0=3"}, delimiter = '=')
    void plus(String value, int expected) {
        assertThat(calculator.calculate(value)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "뺄샘")
    @CsvSource(value = {"2 - 2=0", "1 - 2 - 3=-4", "10 - 2=8"}, delimiter = '=')
    void minus(String value, int expected) {
        assertThat(calculator.calculate(value)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "곱셈")
    @CsvSource(value = {"1 * 1=1", "1 * 2 * 3=6", "0 * -999=0"}, delimiter = '=')
    void multiplication(String value, int expected) {
        assertThat(calculator.calculate(value)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "나눗셈")
    @CsvSource(value = {"1 * 1=1", "1 * 2 * 3=6", "0 * -999=0"}, delimiter = '=')
    void division(String value, int expected) {
        assertThat(calculator.calculate(value)).isEqualTo(expected);
    }

    @Test
    @DisplayName(value = "혼합")
    void mix() {
        String input = "2 + 3 * 4 / 2 + 1 - 6 + 10 - 11 * 191";
        assertThat(calculator.calculate(input)).isEqualTo(764);
    }

    @ParameterizedTest(name = "연산자 생성")
    @MethodSource(value = "stringOperatorProvider")
    void operator(String input, Operator operator) {
        assertThat(Operator.getInstance(input)).isEqualTo(operator);
    }

    static Stream<Arguments> stringOperatorProvider() {
        return Stream.of(
            Arguments.arguments("+", Operator.PLUS),
            Arguments.arguments("-", Operator.MINUS),
            Arguments.arguments("*", Operator.MULTIPLICATION),
            Arguments.arguments("/", Operator.DIVISION)
        );
    }

    @Test
    @DisplayName(value = "잘못된 연산자를 입력하면 에러를 던진다.")
    void throwExceptionIfWrongOperator() {
        assertThatThrownBy(() -> Operator.getInstance("%")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Operator.getInstance("* *")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName(value = "범위를 넘어선 계샨을 하면 에러를 던진다")
    void throwExceptionIfIntegerOverFlow() {
        assertThatThrownBy(() -> calculator.calculate(Integer.MAX_VALUE + " + " + "1")).isInstanceOf(ArithmeticException.class);
    }

    @Test
    @DisplayName(value = "잘못된 Input값을 입력하면 에러를 던진다.")
    void throwExceptionIfInputWrongValue() {
        assertThatThrownBy(() -> calculator.calculate("1" + "+ " + "1")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> calculator.calculate("1" + " + " + " * " + "1")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> calculator.calculate("1" + " 1 " + " 2 " + "*")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> calculator.calculate(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName(value = "0으로 나누면 에러를 던진다")
    void throwExceptionIfDivideByZero() {
        assertThatThrownBy(() -> calculator.calculate("1 / 0")).isInstanceOf(ArithmeticException.class);
    }
}