package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @DisplayName("+,-,*,/ 연산자에 대해서 알맞은 enum 객체를 반환한다")
    @ParameterizedTest
    @MethodSource("source_calculate_validOperator_shouldSucceed")
    public void calculate_validOperator_shouldSucceed(String operator, Operator expected) {
        assertThat(Operator.generateOperatorBySymbol(operator)).isEqualTo(expected);
    }

    private static Stream<Arguments> source_calculate_validOperator_shouldSucceed() {
        return Stream.of(
                Arguments.of("+", Operator.ADD),
                Arguments.of("-", Operator.SUBTRACT),
                Arguments.of("*", Operator.MULTIPLY),
                Arguments.of("/", Operator.DIVIDE)
        );
    }

    @DisplayName("+,-,*,/ 이외의 연산자에 대해서 IllegalArgumentException throw")
    @ParameterizedTest
    @ValueSource(strings = {"(", "@", "a", "1234"})
    public void calculate_invalidOperator_shouldFail(String operator) {
        assertThatThrownBy(() -> {
            Operator.generateOperatorBySymbol(operator);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
