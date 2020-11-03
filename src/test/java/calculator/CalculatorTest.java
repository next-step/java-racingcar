package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void splitTest() {
        String sample = "1 + 2";

        assertEquals("1", sample.split(" ")[0]);
        assertEquals(1, Integer.parseInt(sample.split(" ")[0]));
    }

    @Test
    void addTest() {
        String add = "1 + 2";

        assertEquals(3, calculator.calculate(add));
    }

    @Test
    void allSignTest() {
        String allSignedFormula = "1 + 2 * 6 - 3 / 5";

        assertEquals(3, calculator.calculate(allSignedFormula));
    }

    @Test
    void wrongNumberFormat() {
        String wrongNumberExpression = "1 + K";

        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> calculator.calculate(wrongNumberExpression));
    }

    @ParameterizedTest
    @ValueSource(strings = {"null", "", " "})
    void emptyTest(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> calculator.calculate(input));
    }
}
