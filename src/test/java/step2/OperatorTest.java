package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import calculator.Operator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorTest {
    @DisplayName("형식에 맞지 않는 문자일 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1", "^", "r", " ", ""})
    void failureByNotMatchedFormat(final String value) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                Operator.getOperator(value));
    }

    @Test
    @DisplayName("형식에 맞는 문자 여부 확인")
    void from() {
        List<String> supportedOperations = Arrays.asList("+", "-", "*", "/");
        supportedOperations.forEach(operation ->
                assertThatCode(() -> Operator.getOperator(operation)).doesNotThrowAnyException());
    }

    @DisplayName("연산자 결과값 일치 여부 테스트")
    @ParameterizedTest
    @MethodSource("operatorCase")
    void moveOrStopCar(Operator operator, int num1, int num2, int result) {
        assertThat(operator.calculate(num1, num2)).isEqualTo(result);
    }

    private static Stream<Arguments> operatorCase() {
        return Stream.of(
                Arguments.of(Operator.ADDITION, 1, 2, 3),
                Arguments.of(Operator.SUBTRACTION, 3, 2, 1),
                Arguments.of(Operator.DIVIDE, 4, 2, 2),
                Arguments.of(Operator.MULTIPLY, 1, 4, 4)
        );
    }
}
