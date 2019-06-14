package calculate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void nullValueCalcuateTest() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> calculator.calculate(""));
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> calculator.calculate(null));
    }
    
    @Test
    void successCalculateTest() {
        Assertions.assertThat(
            calculator.calculate("2 + 3 * 4 / 2")
        ).isEqualTo(10);
        
        Assertions.assertThat(
            calculator.calculate("1 + 3 * 5 + 7")
        ).isEqualTo(27);
    
        Assertions.assertThat(
            calculator.calculate("300 / 100 + 20 * 10 - 20")
        ).isEqualTo(210);
    }
}
