package calculate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    @Test
    void additionTest() {
        Assertions.assertThat(Calculator.ADDITION.calculate(1, 2)).isEqualTo(3);
    }
    
    @Test
    void subtractionTest() {
        Assertions.assertThat(Calculator.SUBTRACTION.calculate(2, 1)).isEqualTo(1);
    }

    @Test
    void divisionTest() {
        Assertions.assertThat(Calculator.DIVISION.calculate(6, 3)).isEqualTo(2);
    }
    
    @Test
    void multiplicationTest() {
        Assertions.assertThat(Calculator.MULTIPLICATION.calculate(1, 2)).isEqualTo(2);
    }
    
    @Test
    void notFourMathSign() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> Calculator.getMathSign("("));
    }
}
