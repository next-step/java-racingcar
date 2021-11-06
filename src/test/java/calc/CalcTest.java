package calc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalcTest {
    @Test
    void 더하기() {
        MyNumber result = Calculator.calculate("1 + 2");
        assertThat(result).isEqualTo(new MyNumber("3"));
    }

    @Test
    void 빼기() {
        MyNumber result = Calculator.calculate("3 - 2");
        assertThat(result).isEqualTo(new MyNumber(1));
    }

    @Test
    void 곱하기() {
        MyNumber result = Calculator.calculate("3 * 2");
        assertThat(result).isEqualTo(new MyNumber(6));
    }

    @Test
    void 나누기() {
        MyNumber result = Calculator.calculate("4 / 2");
        assertThat(result).isEqualTo(new MyNumber(2));

        assertThatThrownBy(() -> {
            Calculator.calculate("4 / 0");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Null체크() {
        assertThatThrownBy(() -> {
            Calculator.calculate(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백체크() {
        assertThatThrownBy(() -> {
            Calculator.calculate("    ");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정의되지_않은_연산자() {
        assertThatThrownBy(() -> {
            Calculator.calculate("3 ** 3");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
