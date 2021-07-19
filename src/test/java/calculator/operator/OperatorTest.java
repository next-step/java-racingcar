package calculator.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("연산자 테스트")
class OperatorTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("덧셈(+) 테스트")
    void addition(int x, int y, int expectedValue) {
        assertThat(Operator.ADD.operate(x, y)).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> addition() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(1, -2, -1),
                Arguments.of(-1, -2, -3)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("뺼셈(-) 테스트")
    void subtract(int x, int y, int expectedValue) {
        assertThat(Operator.SUB.operate(x, y)).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> subtract() {
        return Stream.of(
                Arguments.of(1, 2, -1),
                Arguments.of(1, -2, 3),
                Arguments.of(-1, -2, 1)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("곱셈(*) 테스트")
    void multiply(int x, int y, int expectedValue) {
        assertThat(Operator.MUL.operate(x, y)).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> multiply() {
        return Stream.of(
                Arguments.of(1, 2, 2),
                Arguments.of(1, -2, -2),
                Arguments.of(-1, -2, 2)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("나눗셈(/) 테스트")
    void divide(int x, int y, int expectedValue) {
        assertThat(Operator.DIV.operate(x, y)).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> divide() {
        return Stream.of(
                Arguments.of(4, 2, 2),
                Arguments.of(4, -2, -2),
                Arguments.of(-1, -2, 0)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("문자 기호를 가지고 연산자를 반환한다.")
    void of(String symbol, Operator expectedOperator) {
        assertThat(Operator.of(symbol)).isEqualTo(expectedOperator);
    }

    private static Stream<Arguments> of() {
        return Stream.of(
                Arguments.of("+", Operator.ADD),
                Arguments.of("-", Operator.SUB),
                Arguments.of("*", Operator.MUL),
                Arguments.of("/", Operator.DIV)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1", "`", "~", "\\", "&"})
    @NullAndEmptySource
    @DisplayName("사칙연산 기호가 아닌경우 예외를 발생시킨다.")
    void ofNotSupportedSymbol(String symbol) {
        assertThatThrownBy(() -> Operator.of(symbol)).isInstanceOf(IllegalArgumentException.class);
    }
}