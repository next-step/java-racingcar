import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
