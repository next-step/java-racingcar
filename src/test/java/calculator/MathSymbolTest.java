package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathSymbolTest {
    @Test
    void getMathSymbolTest() {
        assertThat(MathSymbol.PLUS.getMathSymbol()).isEqualTo("+");
    }

    @Test
    void findValidatedSymbolTest() {
        assertAll(
                () -> assertThat(MathSymbol.findValidatedSymbol("+")).isEqualTo(MathSymbol.PLUS),
                () -> assertThrows(IllegalArgumentException.class,() -> MathSymbol.findValidatedSymbol("&"))
        );
    }

    @Test
    void operateTest() {
        assertThat(MathSymbol.PLUS.operate(1,3)).isEqualTo(4);
    }
}
