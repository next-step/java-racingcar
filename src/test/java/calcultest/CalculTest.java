package calcultest;

import calcul.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculTest {
    private Calculator calculator = new Calculator();

    @Test
    void addTest(){

        assertThat(5).isEqualTo(calculator.add(2, 3));
    }

    @Test
    void subTest(){

        assertEquals(5, calculator.subtract(8, 3));
    }

    @Test
    void multiTest(){

        assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    void divisionTest(){

        assertEquals(2, calculator.division(6, 3));
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    void nullCheckTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.nullCheck(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"@"})
    void operationCheckTest(String input) {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.operationCheck(input);
        });
    }
}
