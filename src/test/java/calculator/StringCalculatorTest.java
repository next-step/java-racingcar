package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

    private static StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void add() {
        int add = stringCalculator.add(3, 5);
        assertThat(add).isEqualTo(8);
    }

    @Test
    void subtract() {
        int subtract = stringCalculator.subtract(5, 2);
        assertThat(subtract).isEqualTo(3);
    }

    @Test
    void multiply() {
        int multiply = stringCalculator.multiply(7, 3);
        assertThat(multiply).isEqualTo(21);
    }

    @Test
    void divide() {
        int divide = stringCalculator.divide(20, 4);
        assertThat(divide).isEqualTo(5);
    }

    @Test
    void isNotEmpty() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> stringCalculator.isNotEmpty(null));
        assertThatIllegalArgumentException()
            .isThrownBy(() -> stringCalculator.isNotEmpty(" "));
    }

    @Test
    void isOperation() {
        assertThat(stringCalculator.isOperation("+")).isEqualTo("+");
        assertThatIllegalArgumentException()
            .isThrownBy(() -> stringCalculator.isOperation("!"));
        assertThatIllegalArgumentException()
            .isThrownBy(() -> stringCalculator.isOperation("&"));
    }

    @Test
    void calculate() {
        assertThat(stringCalculator.calculate("2 * 5 + 10 / 2".split(" "))).isEqualTo(10);
    }
}
