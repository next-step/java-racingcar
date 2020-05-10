package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperationSymbolTest {

    @ParameterizedTest
    @CsvSource(value = { "1,1,2", "2,2,4", "3,3,6" })
    @DisplayName("더하기 테스트")
    void plus(double firstNumber, double secondNumber, double result) {
        assertThat(OperationSymbol.PLUS.calculate(firstNumber, secondNumber)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = { "1,1,0", "2,2,0", "3,1,2" })
    @DisplayName("뺄셈 테스트")
    void minus(double firstNumber, double secondNumber, double result) {
        assertThat(OperationSymbol.MINUS.calculate(firstNumber, secondNumber)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = { "1,1,1", "2,2,4", "3,3,9" })
    @DisplayName("곱셉 테스트")
    void multiply(double firstNumber, double secondNumber, double result) {
        assertThat(OperationSymbol.MULTIPLY.calculate(firstNumber, secondNumber)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = { "1,1,1", "2,2,1", "1,2,0.5" })
    @DisplayName("나누기 테스트")
    void division(double firstNumber, double secondNumber, double result) {
        assertThat(OperationSymbol.DIVIDE.calculate(firstNumber, secondNumber)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = { "+", "-", "*", "/" })
    @DisplayName("사칙 연산기호 찾기 테스트")
    void getOperationSymbol(String symbol) {
        assertThat(OperationSymbol.getOperationSymbol(symbol)).isNotNull();
    }

    @Test
    @DisplayName("사칙 연산기호가 아닐 경우 IllegalArgumentException 발생")
    void notOperationSymbol() {
        assertThatThrownBy(() -> OperationSymbol.getOperationSymbol("!")).isInstanceOf(IllegalArgumentException.class);
    }
}