package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathSymbolTest {
    @Test
    void enumTest() {
        Assertions.assertThat(MathSymbol.PLUS.getMathSymbol()).isEqualTo("+");
    }
}
