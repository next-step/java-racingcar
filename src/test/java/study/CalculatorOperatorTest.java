package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * Created by wyparks2@gmail.com on 2019-06-15
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class CalculatorOperatorTest {
    @BeforeEach
    void setUp() {

    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void 허용_연산자_검증(String input) {
        CalculatorOperator.fromString(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"!", "2", "A", "한"})
    void 비허용_연산자_검증(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CalculatorOperator.fromString(input));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2",
            "100, 2",
            "13, 12",
            "111, 2222"
    })
    void 더하기(int left, int right) {
        assertThat(CalculatorOperator.ADD.calculate(left, right)).isEqualTo(left + right);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2",
            "100, 2",
            "13, 12",
            "111, 2222"
    })
    void 빼기(int left, int right) {
        assertThat(CalculatorOperator.SUBTRACT.calculate(left, right)).isEqualTo(left - right);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2",
            "100, 2",
            "13, 12",
            "111, 2222"
    })
    void 곱하기(int left, int right) {
        assertThat(CalculatorOperator.MULTIPLY.calculate(left, right)).isEqualTo(left * right);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2",
            "100, 2",
            "13, 12",
            "111, 2222"
    })
    void 나누기(int left, int right) {
        assertThat(CalculatorOperator.DIVIDE.calculate(left, right)).isEqualTo(left / right);
    }

    @Test
    void 나누기_분모가_0일경우_에러발생() {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> CalculatorOperator.DIVIDE.calculate(1, 0));
    }

    @AfterEach
    void tearDown() {

    }
}
