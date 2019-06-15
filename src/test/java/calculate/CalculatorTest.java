package calculate;

import static calculate.Calculator.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    
    @Test
    void nullValueCalcuateTest() {
        assertThatIllegalArgumentException()
          .isThrownBy(() -> calculate(""))
          .withMessage(ErrorMessage.EMPTY_VALUE.getMessage());
        assertThatIllegalArgumentException()
          .isThrownBy(() -> calculate(null))
          .withMessage(ErrorMessage.EMPTY_VALUE.getMessage());
    }
    
    @Test
    void successCalculateTest() {
        assertThat(calculate("2 + 3 * 4 / 2")).isEqualTo(10);
        assertThat(calculate("1 + 3 * 5 + 7")).isEqualTo(27);
        assertThat(calculate("300 / 100 + 20 * 10 - 20")).isEqualTo(210);
    }
}
