import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IntOperatorTest {

    @ParameterizedTest
    @MethodSource("providerOfIntOperator")
    void operate(int left, int right, IntOperator operator, int expected) {
        int result = operator.operate(left, right);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"+,ADD", "-,SUBTRACT", "*,MULTIPLY", "/,DIVIDE"})
    void of(String sign, String name) {
        IntOperator operator = IntOperator.of(sign);
        assertThat(operator).isEqualTo(IntOperator.valueOf(name));
    }

    static Stream<Arguments> providerOfIntOperator() {
        return Stream.of(
                Arguments.of(1, 2, IntOperator.ADD, 3),
                Arguments.of(1, 2, IntOperator.SUBTRACT, -1),
                Arguments.of(1, 2, IntOperator.MULTIPLY, 2),
                Arguments.of(1, 2, IntOperator.DIVIDE, 0)
        );
    }
}
