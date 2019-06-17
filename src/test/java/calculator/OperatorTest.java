package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static calculator.Operator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTest {

    @Test
    void operatorTest() {
        assertThat(Operator.PLUS.calculator(2,2)).isEqualTo(4);
        assertThat(Operator.MINUS.calculator(3,2)).isEqualTo(1);
        assertThat(Operator.MULTIPLY.calculator(2,3)).isEqualTo(6);
        assertThat(Operator.DIVIDE.calculator(2,2)).isEqualTo(1);
    }

    @Test @DisplayName("제수가 0일 경우 Exception")
    void divideByZeroThanFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> DIVIDE.calculator(4, 0));
    }

    @Test
    void operatorWrongSymbolThanFail() {
        String symbol = "&";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.from(symbol))
                .withMessageMatching(symbol + "은 지원하지 않는 연산기호입니다.");
    }

    @ParameterizedTest
    @CsvSource({
            "+, PLUS",
            "-, MINUS",
            "/, DIVIDE",
            "*, MULTIPLY"
    })
    void getOperatorBySymbol(String symbol, Operator operator) {
        assertThat(Operator.from(symbol)).isEqualTo(operator);
    }
}