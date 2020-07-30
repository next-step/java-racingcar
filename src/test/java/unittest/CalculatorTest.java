package unittest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    static CalculatorImpl cal;


    @BeforeAll
    public static void set() {
        cal = new CalculatorImpl();
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







}
