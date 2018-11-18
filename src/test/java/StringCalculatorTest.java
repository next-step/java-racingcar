import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    @Test
    public void 문자열계산기_실행() {
        int result = StringCalculator.calculate("1 + 2");
        assertThat(result).isEqualTo(3);

        result = StringCalculator.calculate("1 + 2 + 3");
        assertThat(result).isEqualTo(6);

        result = StringCalculator.calculate("1 + 2 * 4 / 3");
        assertThat(result).isEqualTo(4);
    }
}
