import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator calculator = new StringCalculator();

    @Test
    void plusTest() {
        assertEquals(5, calculator.plus(2, "3"));
    }

    @Test
    void minusTest() {
        assertEquals(7, calculator.minus(10, "3"));
    }

    @Test
    void multiplyTest() {
        assertEquals(10, calculator.multiply(2, "5"));
    }

    @Test
    void divisionTest() {
        assertEquals(10, calculator.division(20, "2"));
    }

    @Test
    void calculateTest(){
        assertEquals(10, calculator.calculate("2 + 3 * 4 / 2"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"#", "$"})
    void partCalculatePermittedOperatorTest(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            assertEquals(10, calculator.partCalculate(input, 5, "5"));
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    void partCalculateNullInputTest(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            assertEquals(10, calculator.partCalculate("+", 5, input));
        });
    }
}