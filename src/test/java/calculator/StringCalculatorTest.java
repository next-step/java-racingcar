package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    @DisplayName("계산기 계산 값을 비교")
    void calculate() {
        // given and expect
        assertThat(StringCalculator.of("2 + 3 * 4 / 2").calculate()).isEqualTo(10);
        assertThat(StringCalculator.of("2 + 3 * 4 / 1").calculate()).isEqualTo(20);
        assertThat(StringCalculator.of("1 + 3 * 4 / 2").calculate()).isEqualTo(8);
    }


    @DisplayName("잘못된 수식이 들어 갈 경우 IllegalArgumentException")
    @ParameterizedTest
    @ValueSource(strings = {
            "5 @ 1",
            "5 [ 3",
            "1 ) 1",
    })
    void throwIllegalArgumentExceptionWhenInputIsNotSignForMath(final String input) {
        // given and expect
        assertThatThrownBy(() -> StringCalculator.of(input).calculate()).isInstanceOf(IllegalArgumentException.class);
    }

}
