package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void 덧셈_테스트() {
        int result = calculator.calculate("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 뺄셈_테스트() {
        int result = calculator.calculate("2 - 1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 곱셈_테스트() {
        int result = calculator.calculate("-1 * -1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 나눗셈_테스트() {
        int result = calculator.calculate("4 / 2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 숫자_사칙연산_부호가_아닐때_예외_테스트() {
        assertThatThrownBy(() -> calculator.calculate("4 r 2"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈_문자열_혹은_이상한_식_테스트() {
        assertThatThrownBy(() -> calculator.calculate(""))
            .isInstanceOf(IllegalArgumentException.class);
    }
}