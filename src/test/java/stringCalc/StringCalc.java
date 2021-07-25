package stringCalc;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalc {

    @ParameterizedTest
    @ValueSource(strings = "2 + 3")
    public void addition(String input) {
        int output = Calc.calc(input);
        assertThat(output).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = "5 - 2")
    public void subtraction(String input) {
        int output = Calc.calc(input);
        assertThat(output).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = "10 / 2")
    public void division(String input) {
        int output = Calc.calc(input);

        assertThat(output).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = "4 * 3")
    public void multiplication(String input) {
        int output = Calc.calc(input);

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

    @ParameterizedTest
    @ValueSource(strings = {"", "0" ,"2 ! 3 * 2 + 3"})
    public void inputIsNull(String input) {

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            String[] values = input.split(" ");
            if(values.length < 2) throw new IllegalArgumentException();
            int output = Calc.calc(values[0] + " " + values[1] + " " +values[2]);
            output = Calc.calc(output + " " + values[3] + " " + values[4]);
            output = Calc.calc(output + " " + values[5] + " " + values[6]);
        });
    }
}
