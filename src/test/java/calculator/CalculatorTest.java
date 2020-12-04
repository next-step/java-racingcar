package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @DisplayName("숫자 더하기")
    @Test
    public void plus() {
        assertThat(Calculator.calculate(6, 3, "+")).isEqualTo(9);
    }

}
