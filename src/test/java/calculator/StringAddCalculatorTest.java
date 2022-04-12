package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class StringAddCalculatorTest {

    @DisplayName("빈문자열이거나 null일 경우 0을 반환")
    @Test
    void 빈문자열이거나_널일경우() {
        assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
        assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 입력할 경우 해당 숫자 반환")
    @Test
    void 숫자하나반환() {
        assertThat(StringAddCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @DisplayName("숫자 두개를 ','로 입력하면 두 수의 합을 반환")
    @Test
    void 쉼표_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @DisplayName("구분자 ',' 외에 ':' 구분자 사용가능 테스트")
    @Test
    void 쉼표_콜론구분자() {
        assertThat(StringAddCalculator.splitAndSum("1,2:4")).isEqualTo(7);
    }

    @DisplayName("//, \n문자 사이의 커스텀구분자를 지정하기 관련 테스트")
    @Test
    void 커스텀구분자() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }


    @DisplayName("음수 전달할 경우 RuntimeException 발생")
    @Test
    void 음수전달_익셉션발생() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
