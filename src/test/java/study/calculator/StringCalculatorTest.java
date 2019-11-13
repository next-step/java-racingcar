package study.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import calculator.StringCalculator;

import static org.assertj.core.api.Assertions.*;
public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    void exceptionTest(String input) {
        stringCalculator = new StringCalculator(input);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.execute();
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
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
    @ValueSource(strings = {"1 + 2"})
    void addTest(String input) {
        stringCalculator = new StringCalculator(input);
        assertThat(stringCalculator.execute()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 - 2"})
    void subtractTest(String input) {
        stringCalculator = new StringCalculator(input);
        assertThat(stringCalculator.execute()).isEqualTo(-1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"4 / 2"})
    void divideTest(String input) {
        stringCalculator = new StringCalculator(input);
        assertThat(stringCalculator.execute()).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5 * 2"})
    void multiplyTest(String input) {
        stringCalculator = new StringCalculator(input);
        assertThat(stringCalculator.execute()).isEqualTo(10);
    }
}
