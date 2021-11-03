package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by owen.ny on 2021/11/03.
 */
public class CalculatorTest {
    @Test
    public void 계산() {
        assertThat(Calculator.calculate("1 + 2")).isEqualTo(new MyNumber(3));
        assertThat(Calculator.calculate("3 - 2")).isEqualTo(new MyNumber(1));
        assertThat(Calculator.calculate("3 * 2")).isEqualTo(new MyNumber(6));
        assertThat(Calculator.calculate("4 / 2")).isEqualTo(new MyNumber(2));
    }

    @Test
    public void 계산_연산자_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            Calculator.calculate("1 & 2");
        });
    }

}
