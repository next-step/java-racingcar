package calculate;

import static org.assertj.core.api.Assertions.*;
import static calculate.Operator.*;
import org.junit.jupiter.api.Test;

class OperatorTest {
    @Test
    void additionTest() {
        assertThat(ADDITION.calculate(1, 2)).isEqualTo(3);
    }
    
    @Test
    void subtractionTest() {
        assertThat(SUBTRACTION.calculate(2, 1)).isEqualTo(1);
    }

    @Test
    void divisionTest() {
        assertThat(DIVISION.calculate(6, 3)).isEqualTo(2);
    }
    
    @Test
    void multiplicationTest() {
        assertThat(MULTIPLICATION.calculate(1, 2)).isEqualTo(2);
    }
    
    @Test
    void notFourMathSign() {
        assertThatIllegalArgumentException().isThrownBy(() -> getMathSign("("));
    }
}
