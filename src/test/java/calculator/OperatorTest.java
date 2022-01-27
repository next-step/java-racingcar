package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Operator 테스트")
class OperatorTest {

    @Test
    @DisplayName("+에 맞는 Enum을 반환하는 테스트")
    void findAddTest() {
        Operator symbol = Operator.findBySymbol("+");
        assertThat(symbol).isEqualTo(Operator.ADD);
    }

    @Test
    @DisplayName("-에 맞는 Enum을 반환하는 테스트")
    void findSubtractTest() {
        Operator symbol = Operator.findBySymbol("-");
        assertThat(symbol).isEqualTo(Operator.SUBTRACT);
    }

    @Test
    @DisplayName("*에 맞는 Enum을 반환하는 테스트")
    void findMultiplyTest() {
        Operator symbol = Operator.findBySymbol("*");
        assertThat(symbol).isEqualTo(Operator.MULTIPLY);
    }

    @Test
    @DisplayName("/에 맞는 Enum을 반환하는 테스트")
    void findDivideTest() {
        Operator symbol = Operator.findBySymbol("/");
        assertThat(symbol).isEqualTo(Operator.DIVIDE);
    }

    @Test
    @DisplayName("+, -, *, / 가 아니면 예외를 반환하는 테스트")
    void findBySymbolExceptionTest() {
        assertThatThrownBy(() -> Operator.findBySymbol("?"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
