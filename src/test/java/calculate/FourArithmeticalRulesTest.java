package calculate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FourArithmeticalRulesTest {
    @Test
    void additionTest() {
        Assertions.assertThat(FourArithmeticalRules.ADDITION.calculate(1, 2)).isEqualTo(3);
    }
    
    @Test
    void subtractionTest() {
        Assertions.assertThat(FourArithmeticalRules.SUBTRACTION.calculate(2, 1)).isEqualTo(1);
    }

    @Test
    void divisionTest() {
        Assertions.assertThat(FourArithmeticalRules.DIVISION.calculate(6, 3)).isEqualTo(2);
    }
    
    @Test
    void multiplicationTest() {
        Assertions.assertThat(FourArithmeticalRules.MULTIPLICATION.calculate(1, 2)).isEqualTo(2);
    }
    
    @Test
    void notFourMathSign() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> FourArithmeticalRules.getMathSign("("));
    }
}
