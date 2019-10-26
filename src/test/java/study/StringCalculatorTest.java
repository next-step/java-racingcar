package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }


    @ParameterizedTest
    @ValueSource(strings = {"", " ", "1"})
    void inputBlankTest(String input) {
        assertThat(input).isBlank();
    }

    @ParameterizedTest
    @ValueSource(strings = {"/"})
    void parsingTest(String input) {
        assertThatThrownBy(() -> {
            Integer.parseInt(input);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageMatching("For input string: \""+input+"\"");
    }

    @ParameterizedTest
    @ValueSource(strings = {})

    @Test
    void addTest() {
        assertThat(stringCalculator.execute("1 + 2")).isEqualTo(3);
    }

    @Test
    void subtractTest() {
        assertThat(stringCalculator.execute("1 - 2")).isEqualTo(-1);
    }

    @Test
    void divideTest() {
        assertThat(stringCalculator.execute("4 / 2")).isEqualTo(2);
    }

    @Test
    void multiplyTest() {
        assertThat(stringCalculator.execute("5 * 2")).isEqualTo(10);
    }

    @Test
    void inputValidatorTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.inputValidator(null);
            stringCalculator.inputValidator("");
        });
    }
}
