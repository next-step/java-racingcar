package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    void addTest() {

        assertThat(5).isEqualTo(calculator.add(2, 3));
    }

    @Test
    void subTest() {

        assertEquals(5, calculator.sub(8, 3));
    }

    @Test
    void multiTest() {

        assertEquals(6, calculator.multi(2, 3));
    }

    @Test
    void divisionTest() {

        assertEquals(2, calculator.division(6, 3));
    }

    @ParameterizedTest
    @ValueSource(strings = {"88", " "})
    void nullCheckTest(String input) {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.nullCheck(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void operCheckTest(String input) {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.operCheck(input);
        });
    }
}
