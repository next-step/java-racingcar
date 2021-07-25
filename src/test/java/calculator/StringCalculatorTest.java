package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringCalculatorTest {

    @DisplayName("덧셈")
    @Test
    void 덧셈() {
        int result = StringCalculator.cal("2 + 3");
        assertThat(result).isEqualTo(5);
    }

    @DisplayName("뺄셈")
    @Test
    void 뺄셈() {
        int result = StringCalculator.cal("5 - 2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("곱셈")
    @Test
    void 곱셈() {
        int result = StringCalculator.cal("5 * 2");
        assertThat(result).isEqualTo(10);
    }

    @DisplayName("나눗셈")
    @Test
    void 나눗셈() {
        int result = StringCalculator.cal("10 / 2");
        assertThat(result).isEqualTo(5);
    }

    @DisplayName("입력 값 null 체크")
    @Test
    void 입력_값_null_체크() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> StringCalculator.cal(null));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> StringCalculator.cal(""));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> StringCalculator.cal(" "));
    }

    @DisplayName("사칙연산 기호 체크")
    @Test
    void 사칙연산_기호_체크() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()-> StringCalculator.cal("10 ? 2"));
    }

    @DisplayName("통합 기능 테스트")
    @Test
    void 모든_기능() {
        assertThat(StringCalculator.cal("2 + 3 * 4 / 2")).isEqualTo(10);
    }

}
