package calculator_tdd;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PositiveTest {
    @Test
    public void 음수로_생성_시_RuntimeException_발생() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Positive(-1));
    }

}
