import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    @ParameterizedTest
    @NullSource
    void inputNullTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator(input);
        });
    }
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void inputEmptyTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator(input);
        });
    }
    @DisplayName("문자열나누기")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 5 + 10", "2 * 5 / 10"})
    void strSplitTest(String input) {
        Calculator calculator = new Calculator(input);
        assertThat(calculator.split(input)).isInstanceOf(String[].class);
    }
    @DisplayName("+")
    @ParameterizedTest
    @CsvSource("'1','2'")
    void  plusTest(double a, double b) {
        assertThat(3).isEqualTo(calculator.plus(a,b));
    }
    @DisplayName("-")
    @ParameterizedTest
    @CsvSource("'4','2'")
    void  minusTest(double a, double b) {
        assertThat(2).isEqualTo(calculator.minus(a,b));
    }
    @DisplayName("*")
    @ParameterizedTest
    @CsvSource("'1','2'")
    void  multiplyTest(double a, double b) {
        assertThat(2).isEqualTo(calculator.multiply(a,b));
    }
    @DisplayName("/")
    @ParameterizedTest
    @CsvSource("'4','2'")
    void  divideTest(double a, double b) {
        assertThat(2).isEqualTo(calculator.divide(a,b));
    }

    @Test
    @DisplayName("특수 문자 예외")
    @ParameterizedTest
    @CsvSource("1 + 2 , 3")
    void inputDisabledCharacterTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator(input);
            calculator.getcalRes();
        });
    }
}
