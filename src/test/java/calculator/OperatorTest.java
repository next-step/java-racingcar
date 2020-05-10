package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class OperatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1,2", "2,2,4", "1,5,6"})
    @DisplayName("더하기 테스트")
    void plus(int firstNumber, int secondNumber, int result) {
        assertThat(Operator.PLUS.calculate(firstNumber,secondNumber)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1,0", "2,2,0", "1,5,-4"})
    @DisplayName("뺄셈 테스트")
    void minus(int firstNumber, int secondNumber, int result) {
        assertThat(Operator.MINIS.calculate(firstNumber, secondNumber)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1,1", "2,2,4", "1,5,5"})
    @DisplayName("곱셉 테스트")
    void multiply(int firstNumber, int secondNumber, int result) {
        assertThat(Operator.MULTIPLY.calculate(firstNumber, secondNumber)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1,1", "2,2,1", "1,5,0.2"})
    @DisplayName("나누기 테스트")
    void division(int firstNumber, int secondNumber, String result) {
        assertThat(Operator.DIVISION.calculate(firstNumber, secondNumber)).isEqualTo(Double.parseDouble(result));
    }

    @ParameterizedTest
    @MethodSource("provideOperator")
    @DisplayName("연산자 찾기 테스트")
    void findOperator(String operator, Operator operatorEnum) {
        assertThat(Operator.findOperator(operator)).isNotNull();
        assertThat(Operator.findOperator(operator)).isEqualTo(operatorEnum);
    }

    @Test
    @DisplayName("사칙 연산자가 아닌경우 Exception")
    void notExistsOperator() {
        assertThatThrownBy(() -> Operator.findOperator("&"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0으로 나누기 시도시 Exception")
    void divisionByZero() {
        assertThatThrownBy(() -> Operator.DIVISION.calculate(1.0, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideOperator() {
        return Stream.of(
                Arguments.of("+", Operator.PLUS),
                Arguments.of("-", Operator.MINIS),
                Arguments.of("*", Operator.MULTIPLY),
                Arguments.of("/", Operator.DIVISION)
        );
    }
}
