package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", " "})
    void checkString(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.checkString(input);
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", " ", "!", "@", "#", "$", "%", "^", "&", "(", ")"})
    void checkCalculate(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.checkCalculation(input);
        });
    }

    @Test
    void plus() {
        int result = CalculationType.PLUS.calculation.calculate(1, 2);
        assertThat(result).isEqualTo(3);
    }

   @Test
    void minus() {
       int result = CalculationType.MINUS.calculation.calculate(1, 2);
        assertThat(result).isEqualTo(-1);
    }

   @Test
    void multiply() {
       int result = CalculationType.MULTYPLY.calculation.calculate(1, 2);
        assertThat(result).isEqualTo(2);
    }

   @Test
    void divide() {
       int result = CalculationType.DIVIDE.calculation.calculate(2, 1);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void calculate() {
        int result = StringCalculator.getResult("1 + 2 * 3 + 4");
        assertThat(result).isEqualTo(13);
    }

}
