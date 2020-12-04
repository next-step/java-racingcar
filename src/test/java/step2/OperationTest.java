package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;


class OperationTest {

    @ParameterizedTest
    @MethodSource("generatePlusData")
    @DisplayName("더하기 기능 테스트")
    public void plus(double[] input, double expected) {
        assertThat(Operation.PLUS.calculate(input[0], input[1])).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("generateMinusData")
    @DisplayName("빼기 기능 테스트")
    public void minus(double[] input, double expected) {
        assertThat(Operation.MINUS.calculate(input[0], input[1])).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("generateTimesData")
    @DisplayName("곱하기 기능 테스트")
    public void times(double[] input, double expected) {
        assertThat(Operation.TIMES.calculate(input[0], input[1])).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("generateDivideData")
    @DisplayName("나누기 기능 테스트")
    public void divide(double[] input, double expected) {
        assertThat(Operation.DIVIDE.calculate(input[0], input[1])).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"$", "^", "&"})
    @DisplayName("사칙연산에 없는 연산자의 경우 IllegalArgumentException")
    public void operation_illegalArgumentExceptionTest(String input) {
        assertThatThrownBy(() -> {
            Operation.getOperation(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> generatePlusData() {
        return Stream.of(
                Arguments.of(new double[]{6, 3}, 9),
                Arguments.of(new double[]{9, 3}, 12)
        );
    }

    static Stream<Arguments> generateMinusData() {
        return Stream.of(
                Arguments.of(new double[]{6, 3}, 3),
                Arguments.of(new double[]{9, 3}, 6)
        );
    }

    static Stream<Arguments> generateTimesData() {
        return Stream.of(
                Arguments.of(new double[]{6, 3}, 18),
                Arguments.of(new double[]{9, 3}, 27)
        );
    }

    static Stream<Arguments> generateDivideData() {
        return Stream.of(
                Arguments.of(new double[]{6, 3}, 2),
                Arguments.of(new double[]{9, 3}, 3)
        );
    }
}