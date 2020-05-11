package calculator.operation;

import calculator.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ArithmeticOperationStrategyTest {

    @DisplayName("인자로 들어온 값에 해당하는 Enum 클래스 반환")
    @ParameterizedTest
    @MethodSource("existValueCase")
    void of(final String value, final ArithmeticOperationStrategy expected) {
        assertThat(ArithmeticOperationStrategy.of(value)).isEqualTo(expected);
    }

    private static Stream<Arguments> existValueCase() {
        return Stream.of(
                Arguments.of("+", ArithmeticOperationStrategy.PLUS),
                Arguments.of("-", ArithmeticOperationStrategy.MINUS),
                Arguments.of("*", ArithmeticOperationStrategy.TIMES),
                Arguments.of("/", ArithmeticOperationStrategy.DIVIDE)
        );
    }

    @DisplayName("Enum 클래스에 없는 인자의 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"#", "%", "s", "test"})
    void failureOf(final String value) {
        assertThatThrownBy(() -> ArithmeticOperationStrategy.of(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_SUPPORTED_OPERATOR);
    }
}
