import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

    StringCalculator calc;

    @BeforeEach
    public void setUp() {
        calc = new StringCalculator();
    }

    @Test
    public void add() {
        String input = "12 + 34";

        assertThat(calc.run(input)).isEqualTo(46);
    }

    @Test
    public void sub() {
        String input = "34 - 12";

        assertThat(calc.run(input)).isEqualTo(22);
    }

    @Test
    public void multiply() {
        String input = "11 * 11";

        assertThat(calc.run(input)).isEqualTo(121);
    }

    @Test
    public void divide() {
        String input = "123 / 22";

        assertThat(calc.run(input)).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "            "})
    @NullSource
    public void nullOrEmptyInput_throwingException(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calc.run(input));
    }
}
