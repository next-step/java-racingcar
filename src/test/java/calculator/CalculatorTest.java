package calculator;

import org.junit.jupiter.api.Test;

import static calculator.Calculator.splitAndSum;
import static org.assertj.core.api.Assertions.*;

class CalculatorTest {
    @Test
    void null_or_blank_체크() throws Exception {
        // 가독성을 챙기기 위해 result 변수를 선언하는 것 vs 들여쓰기로 라인 수를 줄이는것
        assertThat(splitAndSum(null)).isEqualTo(0);
        assertThat(splitAndSum("")).isEqualTo(0);
    }
    @Test
    void 숫자_하나() throws Exception {
        assertThat(splitAndSum("1")).isEqualTo(1);
    }
    @Test
    void 컴마_구분자() throws Exception {
        assertThat(splitAndSum("1,2")).isEqualTo(3);
    }
    @Test
    void 컴마_콜론_구분자() throws Exception {
        assertThat(splitAndSum("1,2:3")).isEqualTo(6);
    }
    @Test
    void 커스텀_구분자() throws Exception {
        assertThat(splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }
    @Test
    void 음수_RuntimeException() throws Exception {
        assertThatThrownBy(() -> splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}