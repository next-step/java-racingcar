package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    void 나눗셈() {

    }
    // 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
    @Test
    void null_체크() {
    }

    // 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
    @Test
    void 사칙연산_기호_체크() {

    }

    // 사칙 연산을 모두 포함하는 기능 구현
    @Test
    void 모든_기능() {

    }

}
