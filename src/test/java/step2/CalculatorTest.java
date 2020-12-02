package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"12:true","1:true","+:false","-:false","52:true"}, delimiter = ':')
    @DisplayName("현재 입력된 문자열이 숫자인지 확인하는 테스트")
    public void isNumericTest(String input, boolean expected) {
        assertThat(calculator.isNumeric(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("generateCalculatorData")
    @DisplayName("계산기 테스트")
    public void calculator(String input, double expected) {
        assertThat(calculator.displayResult(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "   ", "      "})
    @DisplayName("input이 공백이면 IllegalArgumentException")
    public void empty_input_illegalArgumentExceptionTest(String input) {
        assertThatThrownBy(() -> {
            calculator.displayResult(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("input이 null이면 IllegalArgumentException")
    public void null_input_illegalArgumentExceptionTest() {
        assertThatThrownBy(() -> {
            calculator.displayResult(null);
        }).isInstanceOf(IllegalArgumentException.class);
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