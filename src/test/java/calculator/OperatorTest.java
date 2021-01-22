package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Operator 테스트")
class OperatorTest {

    @ParameterizedTest
    @CsvSource({
            "'+', 16",
            "'-', 8",
            "'*', 48",
            "'/', 3"
    })
    void calculate(String operator, double expected) {
        // given & when
        double result = Operator.calculate(operator, 12, 4);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    @Test
    void actionShouldThrowException() {
        assertThatThrownBy(
                () -> Operator.calculate("N", 1, 2)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}