package stringCalculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void 문자열_계산(){
        Calculator calculator = new Calculator();
        assertThat(calculator.excuteResult("2 + 3 * 4 / 2"))
            .isEqualTo(10);

    }
}
