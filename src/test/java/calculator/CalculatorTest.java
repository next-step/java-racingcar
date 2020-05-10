package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @DisplayName("입력 값이 null이거나 빈 공백 문자열로 연산을 하면 IllegalArgumentException 발생")
    @Test
    void emptyString_thenThrowIllegalArgumentException(){
        Calculator calculator = new Calculator();

        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(null));
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(""));
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate("\n    \t"));
    }

    @DisplayName("사직연산 기호가가 아닌 기호로 연산을 하면 IllegalArgumentException 발생")
    @Test
    void notSupportedOperator_thenThrowIllegalArgumentException(){
        Calculator calculator = new Calculator();
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate("1 ! 2"));
    }

    @DisplayName("덧셈 연산을 지원한다.")
    @Test
    void plus(){
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate("1 + 2")).isEqualTo(3);
        assertThat(calculator.calculate("2 + 3")).isEqualTo(5);
        assertThat(calculator.calculate("2 + 3 + 5")).isEqualTo(10);
    }

    @DisplayName("뺄샘 연산을 지원한다.")
    @Test
    void minus(){
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate("2 - 1")).isEqualTo(1);
        assertThat(calculator.calculate("2 - 3")).isEqualTo(-1);
        assertThat(calculator.calculate("2 + 3 - 5")).isEqualTo(0);
    }

    @DisplayName("곱셈 연산을 지원한다.")
    @Test
    void multiply(){
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate("2 * 1")).isEqualTo(2);
        assertThat(calculator.calculate("2 * 3")).isEqualTo(6);
        assertThat(calculator.calculate("-2 * -3 * -5")).isEqualTo(-30);
    }

    @DisplayName("나눗셈연산을 지원한다.")
    @Test
    void divide(){
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate("2 / 1")).isEqualTo(2);
        assertThat(calculator.calculate("2 / 3")).isEqualTo(2.0/3);
        assertThat(calculator.calculate("10 / 1 / -3")).isEqualTo(10 / 1 / -3.0);
    }

    @DisplayName("사직연산을 지원한다.")
    @Test
    void calculation(){
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }
}
