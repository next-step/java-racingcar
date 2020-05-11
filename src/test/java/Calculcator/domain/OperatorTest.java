package Calculcator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {

    @DisplayName("사칙연산 기호에 맞는 열거 상수를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void findBySymbol(String symbol) {
        Operator actualOperator = Operator.findBySymbol(symbol);
        assertThat(actualOperator).isIn(Operator.values());
    }

    @DisplayName("Null 또는 공백문자로 열거 상수를 찾으면 IllegalArgumentException을 throw 한다.")
    @NullAndEmptySource
    @ParameterizedTest
    void findBySymbolAsNullOrEmpty(String symbol) {
        assertThatThrownBy(() -> Operator.findBySymbol(symbol))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Null 또는 공백 문자는 연산자가 될 수 없습니다.");
    }

    @DisplayName("사칙연산 기호가 아니면 IllegalArgumentException throw 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"^", "%"})
    void findBySymbolThrowsException(String symbol) {
        assertThatThrownBy(() -> Operator.findBySymbol(symbol))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사칙연산 기호가 아닙니다. - " + symbol);
    }

    @DisplayName("사칙연산 기호에 맞는 계산 결과를 반환한다.")
    @ParameterizedTest
    @CsvSource({"+, 6", "-, 2", "*, 8", "/, 2"})
    void compute(String symbol, double result) {
        Operand leftOperand = new Operand(4);
        Operand rightOperand = new Operand(2);

        Operator operator = Operator.findBySymbol(symbol);
        assertThat(operator.compute(leftOperand, rightOperand).getValue()).isEqualTo(result);
    }

    @DisplayName("0으로 나누려고 하면 IllegalArgumentException을 throw 한다.")
    @Test
    void divideAsZeroThrowsException() {
        Operand leftOperand = new Operand(4);
        Operand rightOperand = new Operand(0);

        assertThatThrownBy(() -> Operator.DIVIDE.compute(leftOperand, rightOperand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0 으로 나눌 수 없습니다.");
    }
}
