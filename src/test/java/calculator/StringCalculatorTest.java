package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {


    @Test
    public void calculate_example() {
        assertThat(StringCalculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @Test
    public void add() {
        assertThat(StringCalculator.calculate("4 + 2")).isEqualTo(6);
    }

    @Test
    public void minus() {
        assertThat(StringCalculator.calculate("4 - 2")).isEqualTo(2);
    }

    @Test
    public void multiple() {
        assertThat(StringCalculator.calculate("4 * 2")).isEqualTo(8);
    }

    @Test
    public void divide() {
        assertThat(StringCalculator.calculate("4 / 2")).isEqualTo(2);
    }

    @Test
    public void input_is_null() {
        assertThatThrownBy(() ->
                StringCalculator.calculate(null)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void input_is_empty_string() {
        assertThatThrownBy(() ->
                StringCalculator.calculate("")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사칙연산이 아닌 경우 throw IllegalArgumentException")
    @Test
    public void operator_is_not_4_arithmetic_operations() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> StringCalculator.calculate("4 ^ 2")
        );
    }

    @Test
    public void split() {
        // when
        String[] values = "1 + 2".split(" ");
        // then
        assertThat(values).containsExactly("1", "+", "2");
    }

}
