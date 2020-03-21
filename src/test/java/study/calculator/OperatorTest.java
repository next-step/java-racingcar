package study.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class OperatorTest {
    @DisplayName("덧셈을 테스트 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,1,2", "99999999,99999999,199999998", "-1,-1,-2",
            "-100,100,0", "0,0,0"})
    void plus(float leftSide, float rightSide, float expect) {
        assertThat(Operator.PLUS.run(new Operand(leftSide, rightSide)))
                .isEqualTo(expect);
    }

    @DisplayName("뺄셈을 테스트한다.")
    @ParameterizedTest
    @CsvSource(value = {"5,3,2", "3,5,-2", "-100,100,-200", "0,0,0"})
    void minus(float leftSide, float rightSide, float expect) {
        assertThat(Operator.MINUS.run(new Operand(leftSide, rightSide)))
                .isEqualTo(expect);
    }

    @DisplayName("나눗셈을 테스트한다.")
    @ParameterizedTest
    @CsvSource(value = {"6,3,2", "-6,3,-2", "-6,-3,2", "2,5,0.4", "5,2,2.5",
            "0,2,0"})
    void divide(float leftSide, float rightSide, float expect) {
        assertThat(Operator.DIVIDE.run(new Operand(leftSide, rightSide)))
                .isEqualTo(expect);
    }

    @DisplayName("나눗셈 오류를 테스트한다.")
    @Test
    void divideError() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Operator.DIVIDE.run(new Operand(2, 0));
                });
    }

    @DisplayName("곱셈을 테스트한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,1,1", "5,6,30", "-3,6,-18", "-3,-6,18", "3,0,0",
            "0,0,0"})
    void multiply(float leftSide, float rightSide, float expect) {
        assertThat(Operator.MULTIPLY.run(new Operand(leftSide, rightSide)))
                .isEqualTo(expect);
    }

    @ParameterizedTest
    @MethodSource("provideOperators")
    void matchedOperator(String symbol, Operator operator) {
        assertThat(Operator.symbolOf(symbol)).isEqualTo(operator);
    }

    private static Stream<Arguments> provideOperators() {
        return Stream.of(
                Arguments.of("+", Operator.PLUS),
                Arguments.of("-", Operator.MINUS),
                Arguments.of("/", Operator.DIVIDE),
                Arguments.of("*", Operator.MULTIPLY),
                Arguments.of("?", null)
        );
    }
}
