package calculator.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

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
}