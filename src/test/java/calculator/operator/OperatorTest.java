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
    void add(int x, int y, int expectedValue) {
        assertThat(Operator.ADD.operate(x, y)).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> add() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(1, -2, -1),
                Arguments.of(-1, -2, -3)
        );
    }

}