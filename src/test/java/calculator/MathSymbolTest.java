package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathSymbolTest {
    @Test
    void getMathSymbolTest() {
        assertAll(
                () -> assertThat(MathSymbol.PLUS.getMathSymbol()).isEqualTo("+"),
                () -> assertThat(MathSymbol.MINUS.getMathSymbol()).isEqualTo("-"),
                () -> assertThat(MathSymbol.MULTIPLE.getMathSymbol()).isEqualTo("*"),
                () -> assertThat(MathSymbol.DIVIDE.getMathSymbol()).isEqualTo("/")
        );
    }

    @Test
    @DisplayName("올바른 기호가 들어올떄")
    void findValidatedSymbolTest() {
        assertAll(
                () -> assertThat(MathSymbol.findValidatedSymbol("+")).isEqualTo(MathSymbol.PLUS),
                () -> assertThat(MathSymbol.findValidatedSymbol("-")).isEqualTo(MathSymbol.MINUS),
                () -> assertThat(MathSymbol.findValidatedSymbol("*")).isEqualTo(MathSymbol.MULTIPLE),
                () -> assertThat(MathSymbol.findValidatedSymbol("/")).isEqualTo(MathSymbol.DIVIDE)
        );
    }

    @Test
    @DisplayName("올바르지 않은 기호가 들어올떄")
    void findInValidatedSymbolTest() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> MathSymbol.findValidatedSymbol("&"))
        );
    }

    @Test
    void operateTest() {
        assertThat(MathSymbol.PLUS.operate(1, 3)).isEqualTo(4);
    }
}
