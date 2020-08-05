import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {


    @Test
    public void calculate_example() {
        // given
        String input = "2 + 3 * 4 / 2";

        // when
        int result = StringCalculator.calculate(input);

        // then
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void add() {
        // given
        String input = "4 + 2";

        // when
        int result = StringCalculator.calculate(input);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void minus() {
        // given
        String input = "4 - 2";

        // when
        int result = StringCalculator.calculate(input);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void multiple() {
        // given
        String input = "4 * 2";

        // when
        int result = StringCalculator.calculate(input);

        // then
        assertThat(result).isEqualTo(8);
    }

    @Test
    public void divide() {
        // given
        String input = "4 / 2";

        // when
        int result = StringCalculator.calculate(input);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void input_is_null() {
        // given
        String input = null;

        // when
        assertThatThrownBy(() ->
                StringCalculator.calculate(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void input_is_empty_string() {
        // given
        String input = "";

        // when
        assertThatThrownBy(() ->
                StringCalculator.calculate(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void operator_is_not_4_arithmetic_operations() {
        // given
        String input = "4 ^ 2";

        // when
        assertThatIllegalArgumentException().isThrownBy(
                () -> StringCalculator.calculate(input)
        );
    }

}