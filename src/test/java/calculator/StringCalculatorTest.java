package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.StringCalculator.*;
import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    @Test
    @DisplayName("[요구사항_1] 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    void 요구사항_1() {
        assertThat(splitAndSum(null)).isEqualTo(0);
        assertThat(splitAndSum("")).isEqualTo(0);
    }

    @Test
    @DisplayName("[요구사항_2] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void 요구사항_2() {
        assertThat(splitAndSum("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("[요구사항_3] 숫자 두 개를 콤마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    void 요구사항_3() {
        assertThat(splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("[요구사항_4] 구분자를 콤마(,) 이외에 콜론(;)을 사용할 수 있다.")
    void 요구사항_4() {
        assertThat(splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("[요구사항_5] '//'와 '\n' 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    void 요구사항_5() {
        assertThat(splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("[요구사항_6] 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.")
    void 요구사항_6() {
        assertThatThrownBy(() -> splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
