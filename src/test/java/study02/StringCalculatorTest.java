package study02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    @ParameterizedTest(name="null, 공백체크")
    @NullAndEmptySource
    void validation(String param) {
        assertThatThrownBy(() -> {
            new StringCalculator(param);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("계산결과")
    void result() {
        assertThat(new StringCalculator("2 + 3 * 4 / 2").calculate().getNumber()).isEqualTo(10);
    }

    @Test
    void 덧셈() {
        assertThat(new StringCalculator("2 + 3").calculate().getNumber()).isEqualTo(5);
    }

    @Test
    void 뺄셈() {
        assertThat(new StringCalculator("1 - 2").calculate().getNumber()).isEqualTo(-1);
    }

    @Test
    void 곱셈() {
        assertThat(new StringCalculator("1 * 2").calculate().getNumber()).isEqualTo(2);
    }

    @Test
    void 나눗셈() {
        assertThat(new StringCalculator("4 / 2").calculate().getNumber()).isEqualTo(2);

        assertThatIllegalArgumentException().isThrownBy(() -> new StringCalculator("4 / 0").calculate());
    }
}