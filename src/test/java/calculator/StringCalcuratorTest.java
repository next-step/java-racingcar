package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringCalcuratorTest {

    @DisplayName("덧셈")
    @Test
    void 덧셈() {
        int result = StringCalcurator.cal("2 + 3");
        assertThat(result).isEqualTo(5);
    }

    @DisplayName("뺄셈")
    @Test
    void 뺄셈() {
        int result = StringCalcurator.cal("5 - 2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("곱셈")
    @Test
    void 곱셈() {
        int result = StringCalcurator.cal("5 * 2");
        assertThat(result).isEqualTo(10);
    }

    @DisplayName("나눗셈")
    @Test
    void 나눗셈() {
        int result = StringCalcurator.cal("10 / 2");
        assertThat(result).isEqualTo(5);
    }

    @DisplayName("입력 값 null 체크")
    @Test
    void 입력_값_null_체크() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> StringCalcurator.cal(null));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> StringCalcurator.cal(""));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> StringCalcurator.cal(" "));
    }

    @DisplayName("사칙연산 기호 체크")
    @Test
    void 사칙연산_기호_체크() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->StringCalcurator.cal("10 ? 2"));
    }

    // 사칙 연산을 모두 포함하는 기능 구현
    @Test
    void 모든_기능() {

    }

}
