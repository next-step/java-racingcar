package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 8 :10", "2 + 3 + 10:15", "3 + 8 + 9:20"}, delimiter = ':')
    void add(String input, long expected) {
        long result = calculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"9 - 8 :1", "14 - 3 - 11:0", "111 - 10 - 1:100"}, delimiter = ':')
    void minus(String input, long expected) {
        long result = calculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 * 8 :16", "2 * 3 * 10:60", "3 * 8 * 5:120"}, delimiter = ':')
    void multiple(String input, long expected) {
        long result = calculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 8 :10", "2 + 3 + 10:15", "3 + 8 + 9:20"}, delimiter = ':')
    void divide(String input, long expected) {
        long result = calculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException throw")
    void input_validation() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate("  ");
                });

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate(null);
                });
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    void not_operator() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate("1 @ 3");
                });
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "2 * 3 + 10 / 4 - 3:1"}, delimiter = ':')
    @DisplayName("사칙 연산을 모두 포함하는 기능 구현")
    void calculate_all(String input, long expected) {
        long result = calculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void stack_pop() {
        Stack<Object> objects = new Stack<>();
        assertThatExceptionOfType(EmptyStackException.class)
                .isThrownBy(() -> {
                    Object pop = objects.pop();
                });
    }


}
