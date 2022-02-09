package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OperationTest {

    @ParameterizedTest
    @MethodSource
    void enum_정상_연산_확인(String operator, int firstNumber, int secondNumber, int actual) {
        assertThat(Operation.calculate(operator, firstNumber, secondNumber)).isEqualTo(actual);
    }

    private static Stream<Arguments> enum_정상_연산_확인() {
        return Stream.of(Arguments.of("+", 3, 5, 8), Arguments.of("-", 3, 5, -2),
            Arguments.of("*", 3, 5, 15), Arguments.of("/", 3, 1, 3));
    }

    @Test
    void 사칙연산_기호_아닐_때() {
        assertThatExceptionOfType(ArithmeticException.class).isThrownBy(
            () -> Operation.calculate("w", 3, 1)).withMessage("[ERROR] 사칙연산 기호만 입력해주세요.");
    }

    @Test
    void 나누기_0으로() {
        assertThatExceptionOfType(ArithmeticException.class).isThrownBy(
            () -> Operation.calculate("/", 3, 0)).withMessage("[ERROR] 0으로 나눌 수 없습니다.");
    }
}
