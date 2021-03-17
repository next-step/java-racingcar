package step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperationManagerTest {

    @ParameterizedTest
    @MethodSource("OperationManagerTestValue")
    @DisplayName("OperationManager 사칙연산 대한 테스트")
    void num(String symbol, int first, int second, int expected) {
        assertThat(OperationManager.calculate(symbol, first, second)).isEqualTo(expected);
    }

    private static Stream<Arguments> OperationManagerTestValue() {
        return Stream.of(
                Arguments.of("+", 1, 2, 3),
                Arguments.of("-", 1, 2, -1),
                Arguments.of("-", 5, 1, 4),
                Arguments.of("*", 1, 2, 2),
                Arguments.of("*", 0, 5, 0),
                Arguments.of("*", 0, 3, 0),
                Arguments.of("*", -3, 6, -18),
                Arguments.of("/", 1, 3, 0),
                Arguments.of("/", 5, 3, 1),
                Arguments.of("/", 0, 1, 0)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"1,0", "0,0"})
    @DisplayName("나눗셈 0으로 나누기 Exception 테스트")
    void divArithmeticException(int first, int second) {
        assertThatThrownBy(() -> {
            OperationManager.calculate("/", first, second);
        }).isInstanceOf(ArithmeticException.class);
    }


}
