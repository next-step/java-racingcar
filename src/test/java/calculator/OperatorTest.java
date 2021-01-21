package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("연산 수행기 테스트")
class OperatorTest {
    @DisplayName("사칙연산 기호에 따라 계산을 잘 수행하는지 확인")
    @ParameterizedTest
    @CsvSource({
        "'+', 16",
        "'-', 8",
        "'*', 48",
        "'/', 3"
    })
    void calculate(String sign, double expected) {
        // given & when
        double result = Operator.calculate(sign, 12, 4);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("0으로 나누려고 시도할경우 예외를 발생")
    @Test
    void divideWithZeroShouldThrowException() {
        assertThatThrownBy(
            () -> Operator.calculate("/", 1, 0)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException 발생")
    @Test
    void actionShouldThrowException() {
        assertThatThrownBy(
                () -> Operator.calculate("N", 1, 2)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}