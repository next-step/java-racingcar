package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    void add() {
        int result = Calculator.calculate("2 + 3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void minus() {
        int result = Calculator.calculate("2 - 3");
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void multiply() {
        int result = Calculator.calculate("2 * 3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void divide() {
        int result = Calculator.calculate("3 / 2");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void divideByZero() {
        assertThatThrownBy(() -> Calculator.calculate("3 / 0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌 수 없습니다");
    }

    @Test
    void total() {
        int result = Calculator.calculate("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {" "})
    void nullOrEmpty(String text) {
        assertThatThrownBy(() -> Calculator.calculate(text))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값이 null이거나 빈 공백 문자입니다");
    }

    @Test
    void invalidOperator() {
        assertThatThrownBy(() -> Calculator.calculate("1 x 1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("%s는 사칙연산 기호가 아닙니다.", "x");
    }

}
