package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("[Step2] 문자열 계산기")
class OperatorTest {

    private static Stream<Arguments> operatorChars() {
        return Stream.of(
            Arguments.of("+", Operator.PLUS),
            Arguments.of("-", Operator.MINUS),
            Arguments.of("*", Operator.MULTIPLY),
            Arguments.of("/", Operator.DIVIDE)
        );
    }

    @DisplayName("[성공] 계산")
    @ParameterizedTest
    @MethodSource("operatorChars")
    public void calculate(String expression, Operator expected) {
        // given

        // when
        Operator operator = Operator.find(expression);

        // then
        assertThat(operator).isEqualTo(expected);
    }
}
