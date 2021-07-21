import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalc {

    @Test
    public void addition() {
        int output = Calc.calc("2 + 3");
        assertThat(output).isEqualTo(5);
    }

    @Test
    public void subtraction() {
        int output = Calc.calc("5 - 2");
        assertThat(output).isEqualTo(3);
    }

    @Test
    public void division() {
        int output = Calc.calc("10 / 2");

        assertThat(output).isEqualTo(5);
    }

    @Test
    public void multiplication() {
        int output = Calc.calc("4 * 3");

        assertThat(output).isEqualTo(12);
    }

    @ParameterizedTest
    @ValueSource(strings = "2 + 3 * 4 / 2")
    public void useCalc (String input) {
        String[] values = input.split(" ");
        int output = Calc.calc(values[0] + " " + values[1] + " " +values[2]);
        output = Calc.calc(output + " " + values[3] + " " + values[4]);
        output = Calc.calc(output + " " + values[5] + " " + values[6]);

        assertThat(output).isEqualTo(10);
    }
}
