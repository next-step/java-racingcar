package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 리팩토링 3가지 원칙 반드시 지켜야 할 것 indent 1 - 메서드 분리 else 키워드 사용하지 않기 모든 원시값 포장하기
 */

public class CalculatorTest {

    @Test
    void plus() {
        MyNumber ans = Calculator.calculate(new Expression("2 + 3"));
        assertThat(ans).isEqualTo(new MyNumber(5));
    }

    @Test
    void minus() {
        MyNumber ans = Calculator.calculate(new Expression("3 - 2"));
        assertEquals(new MyNumber(1), ans);
    }

    @Test
    void multiply() {
        MyNumber ans = Calculator.calculate(new Expression("3 * 2"));
        assertEquals(new MyNumber(6), ans);
    }

    @Test
    void divide() {
        MyNumber ans = Calculator.calculate(new Expression("6 / 2"));
        assertEquals(new MyNumber(3), ans);
    }

    @Test
    void longInput() {
        MyNumber ans = Calculator.calculate(new Expression("3 + 3 / 2"));
        assertEquals(new MyNumber(3), ans);
    }

    @Test
    void nullInput() {
        assertThatThrownBy(() -> Calculator.calculate(new Expression(null)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void emptyInput() {
        assertThatThrownBy(() -> Calculator.calculate(new Expression("    ")))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void invalidOperatorInput() {
        assertThatThrownBy(() -> Calculator.calculate(new Expression("3 ^ 2")))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
