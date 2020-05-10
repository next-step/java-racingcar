package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

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
    @DisplayName("사칙 연산기호 찾기 Not Null 여부 테스트")
    void findOperationSymbol(String symbol) {
        assertThat(OperationSymbol.getOperationSymbol(symbol)).isNotNull();
    }

    @Test
    @DisplayName("사칙 연산기호가 아닐 경우 IllegalArgumentException 발생")
    void notOperationSymbol() {
        assertThatThrownBy(() -> OperationSymbol.getOperationSymbol("!")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideStringsForOperationSymbol")
    @DisplayName("사칙 연산기호 찾기 테스트")
    void getOperationSymbol(String symbol, OperationSymbol operationSymbol) {
        assertThat(OperationSymbol.getOperationSymbol(symbol)).isEqualTo(operationSymbol);
    }

    private static Stream<Arguments> provideStringsForOperationSymbol() {
        return Stream.of(
                Arguments.of("+", OperationSymbol.PLUS),
                Arguments.of("-", OperationSymbol.MINUS),
                Arguments.of("*", OperationSymbol.MULTIPLY),
                Arguments.of("/", OperationSymbol.DIVIDE)
        );
    }
}
