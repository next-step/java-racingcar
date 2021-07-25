package stringCaculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CaculatorTest {

    @Test
    @DisplayName("덧셈 계산을 하는지 테스트")
    void sum() {
        int result = Calculator.calculate("3 + 5");
        assertThat(result).isEqualTo(8);
    }

    @Test
    @DisplayName("뺄셈 계산을 하는지 테스트")
    void subtract() {
        int result = Calculator.calculate("10 - 5");
        assertThat(result).isEqualTo(5);

        result = Calculator.calculate("3 - 5");
        assertThat(result).isEqualTo(-2);
    }
}
