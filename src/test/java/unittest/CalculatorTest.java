package unittest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    static Calculator cal;


    @BeforeAll
    public static void set() {
        cal = new Calculator();
    }

    @DisplayName("Default Spilt Input String Test ")
    @ParameterizedTest
    @ValueSource(strings = {"1 - 3"})
    public void splitInputTest(String input) {
        assertThat(cal.splitInput(input)).hasSize(3);
        assertThat(cal.splitInput(input)).isEqualTo(new String[]{"1", "-", "3"});
    }

    @DisplayName("IllegalArgumentException by Null or Empty value ")
    @ParameterizedTest
    @NullSource
    @EmptySource
    public void splitInputTestByEmpty(String input) {
        assertThatThrownBy(() -> {
            cal.splitInput(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Calculate IllegalArgument")
    @Test
    public void caluateTestByIllegalArgument() {
        String[] input = new String[]{"1", "2", "3"};
        assertThatThrownBy(() -> {
            cal.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Calculat Result Test")
    @Test
    public void caluateTest() {
        String[] input = new String[]{"1", "+", "3"};
        assertThat(cal.calculate(input)).isEqualTo(4);

        input = new String[]{"1", "+", "3", "-", "3"};
        assertThat(cal.calculate(input)).isEqualTo(1);

        input = new String[]{"1", "+", "3", "-", "3", "*", "2"};
        assertThat(cal.calculate(input)).isEqualTo(2);

        input = new String[]{"1", "+", "3", "-", "3", "*", "2", "/", "1"};
        assertThat(cal.calculate(input)).isEqualTo(2);
    }

}
