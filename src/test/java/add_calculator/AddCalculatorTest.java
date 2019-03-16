package add_calculator;

import AddCalculator.AddCalculator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddCalculatorTest {
    @Test
    public void return_0_null_or_empty_string() {
        assertThat(AddCalculator.calculate(null)).isEqualTo(0);
        assertThat(AddCalculator.calculate("")).isEqualTo(0);
    }

    @Test
    public void add_numbers_separated_default_character() {
        assertThat(AddCalculator.calculate("3,5")).isEqualTo(8);
        assertThat(AddCalculator.calculate("3:5")).isEqualTo(8);
        assertThat(AddCalculator.calculate("3,5:2")).isEqualTo(10);
    }

    @Test
    public void add_numbers_seperated_custom_character() {
        assertThat(AddCalculator.calculate("//;\n1;2;3")).isEqualTo(6);
    }

    @Test(expected = RuntimeException.class)
    public void occur_exception_number_has_minus() {
        assertThat(AddCalculator.calculate("1:-2:3")).isEqualTo(6);
    }
}
