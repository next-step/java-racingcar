package calculator;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ArithmeticTest {

    @Test
    @DisplayName("사칙연산 테스트")
    public void arithmeticTest() {
        assertThat(Arithmetic.calculate("+", 1, 2)).isEqualTo(3);
        assertThat(Arithmetic.calculate("-", 2, 1)).isEqualTo(1);
        assertThat(Arithmetic.calculate("*", 1, 2)).isEqualTo(2);
        assertThat(Arithmetic.calculate("/", 1, 2)).isEqualTo(0.5);
        assertThat(Arithmetic.calculate("/", 4, 2)).isEqualTo(2);
        assertThat(Arithmetic.calculate("-", 1, 2)).isEqualTo(-1);
    }

    @Test
    @DisplayName("사칙연산 예외 발생 테스트")
    public void arithmeticExceptionTest() {
        assertThatThrownBy(() -> Arithmetic.calculate("/", 2, 0)).isInstanceOf(IllegalArgumentException.class).hasMessage("분모가 0이 되면 안됩니다.");
    }


}
