package step1.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IntegerOperatorsTest {

    @Test
    void validate_SUM_operator() {
        assertThat(IntegerOperators.SUM.operation(10, 10)).isEqualTo(20);
    }

    @Test
    void validate_SUBTRACT_operator() {
        assertThat(IntegerOperators.SUBTRACT.operation(10, 10)).isEqualTo(0);
    }

    @Test
    void validate_MULTIPLY_operator() {
        assertThat(IntegerOperators.MULTIPLY.operation(10, 10)).isEqualTo(100);
    }

    @Test
    void validate_DIVIDE_operator() {
        assertThat(IntegerOperators.DIVIDE.operation(10, 10)).isEqualTo(1);
    }

    @ParameterizedTest
    @MethodSource("integers")
    void operate_flows_left_to_right(int n1, int n2) {
        assertThat(IntegerOperators.SUBTRACT.operation(n1, n2)).isEqualTo(n1 - n2);
        assertThat(IntegerOperators.DIVIDE.operation(n1, n2)).isEqualTo(n1 / n2);
    }

    private static Stream<Arguments> integers() {
        return Stream.of(
                Arguments.of(1, 2),
                Arguments.of(3, 1),
                Arguments.of(15, 5)
        );
    }
}
