package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.StringCalculator.calculate;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    @DisplayName("덧셈에 대한 단위테스트")
    void 덧셈() {
        assertThat(calculate("3 + 1")).isEqualTo(4);
    }
}
