package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MathOperatorTest {

        static Stream<Arguments> operatorTest() {
        return Stream.of(
                arguments("+", 1, 2, 3),
                arguments("-", 7, 3, 4),
                arguments("*", 5, 2, 10),
                arguments("/", 8, 2, 4)
        );
    }

    @ParameterizedTest
    @DisplayName("연산자 동작 테스트")
    @MethodSource
    void operatorTest(String operator, int value1, int value2, int result) {
        assertThat(MathOperator.operate(operator, value1, value2)).isEqualTo(result);
    }

    @Test
    @DisplayName("0으로 나누는 경우 예외 발생 테스트")
    void not_divide_by_zero_test() {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> {
                    MathOperator.operate("/", 1, 0);
                }).withMessageMatching("0 으로 나누기는 불가능 합니다.");
    }

}
