package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
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
    @DisplayName("올바르지 않은 기호가 들어올떄")
    void findInValidatedSymbolTest() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> MathSymbol.findValidatedSymbol("&"))
        );
    }

    @Test
    @DisplayName("MathSymbol 각각의 계산기능 검증")
    void operateTest() {
        assertAll(
                () -> assertThat(MathSymbol.PLUS.operate(1, 31)).isEqualTo(32),
                () -> assertThat(MathSymbol.MINUS.operate(40, 31)).isEqualTo(9),
                () -> assertThat(MathSymbol.MULTIPLE.operate(2, 10)).isEqualTo(20),
                () -> assertThat(MathSymbol.DIVIDE.operate(10, 2)).isEqualTo(5)
        );

    }

    @ParameterizedTest
    @MethodSource("provideMathSymbols")
    @DisplayName("MathSymbol의 모든 상수 검증 테스트")
    void wholeMathSymbolTest(String symbol, MathSymbol Mathsymbol) {
        assertThat(MathSymbol.findValidatedSymbol(symbol)).isEqualTo(Mathsymbol);
    }

    private static Stream<Arguments> provideMathSymbols() {
        return Stream.of(
                Arguments.of("+", MathSymbol.PLUS),
                Arguments.of("-", MathSymbol.MINUS),
                Arguments.of("*", MathSymbol.MULTIPLE),
                Arguments.of("/", MathSymbol.DIVIDE)
        );
    }
}
