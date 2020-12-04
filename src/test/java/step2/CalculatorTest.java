package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    Calculator calculator;
    double result;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"12:true", "1:true", "+:false", "-:false", "52:true"}, delimiter = ':')
    @DisplayName("현재 입력된 문자열이 숫자인지 확인하는 테스트")
    public void isNumericTest(String input, boolean expected) {
        assertThat(calculator.isNumeric(input)).isEqualTo(expected);
    }


    @ParameterizedTest
    @CsvSource(value = {"5 + 5:10", "0 + 5:5", "100 + 10:110"}, delimiter = ':')
    @DisplayName("덧셈 문자열을 입력하면, 합을 반환하는 테스트")
    public void calculator_plus(String input, double expected) {
        assertThat(calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"5 - 5:0", "0 - 5:-5", "100 - 10:90"}, delimiter = ':')
    @DisplayName("뺄셈 문자열을 입력하면, 차를 반환하는 테스트")
    public void calculator_minus(String input, double expected) {
        assertThat(calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"5 * 5:25", "0 * 5:0", "100 * 10:1000"}, delimiter = ':')
    @DisplayName("곱셈 문자열을 입력하면, 곱셈 결과를 반환하는 테스트")
    public void calculator_times(String input, double expected) {
        assertThat(calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"5 / 5:1", "0 / 5:0", "100 / 10:10"}, delimiter = ':')
    @DisplayName("나눗셈 문자열을 입력하면, 나눗셈 결과를 반환하는 테스트")
    public void calculator_divide(String input, double expected) {
        assertThat(calculate(input)).isEqualTo(expected);
    }


    @ParameterizedTest
    @ValueSource(strings = {" ", "   ", "      "})
    @DisplayName("input이 공백이면 IllegalArgumentException")
    public void empty_input_illegalArgumentExceptionTest(String input) {
        assertThatThrownBy(() -> {
            calculator.calculate(result, input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("input이 null이면 IllegalArgumentException")
    public void null_input_illegalArgumentExceptionTest() {
        assertThatThrownBy(() -> {
            calculator.calculate(result, null);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    private double calculate(String input) {
        for (String s : input.split(" ")) {
            result = calculator.calculate(result, s);
        }
        return result;
    }

    static Stream<Arguments> generateCalculatorData() {
        return Stream.of(
                Arguments.of("2 + 3 * 4 / 2", 10),
                Arguments.of("50 - 2 / 2 + 6", 30),
                Arguments.of("7 * 1 * 3 / 3 + 2", 9),
                Arguments.of("5 * 3 / 5 + 1 - 1", 3)
        );
    }
}