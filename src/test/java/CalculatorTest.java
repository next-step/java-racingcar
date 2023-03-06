import calculator.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {

    Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }
    @DisplayName("계산기 더하기 테스트")
    @Test
    void add() {
        int actual = calc.add(1, 2);
        assertThat(actual).isEqualTo(3);
    }

    @DisplayName("계산기 빼기 테스트")
    @Test
    void subtract() {
        int actual = calc.subtract(3, 2);
        assertThat(actual).isEqualTo(1);
    }

    @DisplayName("계산기 곱하기 테스트")
    @Test
    void multiply() {
        int actual = calc.multiply(11, 3);
        assertThat(actual).isEqualTo(33);
    }

    @DisplayName("계산기 나누기 테스트")
    @Test
    void divide() {
        int actual = calc.divide(10, 5);
        assertThat(actual).isEqualTo(2);
    }

    @DisplayName("계산기 연산 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"10 / 2 + 5 - 5 * 2", "100 / 10"} )
    void calculate(String input) {
        int actual = calc.calculator(input);
        assertThat(actual).isEqualTo(10);
    }

    @DisplayName("입력값이 null이거나 빈 공백 문자일 경우/사칙연산이 아닐경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {" ", "", "1 = 3"})
    void testException(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calc.calculator(input));
    }
}
