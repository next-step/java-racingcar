package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CalculatorTest {

    @DisplayName("숫자, 연산자의 수가 올바르게 입력된 수식의 결과값을 반환한다")
    @MethodSource("equations")
    @ParameterizedTest
    public void calculate(String equations, Operand expected) {
        //given
        assertThat(Calculator.calculate(equations)).isEqualTo(expected);
    }

    static Stream<Arguments> equations() {
        return Stream.of(
                Arguments.of("3 + 5", new Operand(8)),
                Arguments.of("2 - 1 * 3", new Operand(3)),
                Arguments.of("6 / 2 * 1", new Operand(3))
        );
    }
}
