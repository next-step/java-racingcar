package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.StringAddCalculator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)")
    @Test
    void 숫자_하나() {
        assertThat(splitAndSum("1")).isEqualTo(1);
    }

    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)")
    @Test
    void 컴마_구분자() {
        assertThat(splitAndSum("1,2")).isEqualTo(3);
    }

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)")
    @Test
    void null_또는_빈문자() {
        assertThat(splitAndSum("")).isEqualTo(0);
        assertThat(splitAndSum(null)).isEqualTo(0);
    }

    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)")
    @Test
    void 콜론_구분자() {
        assertThat(splitAndSum("1,2:3")).isEqualTo(6);
    }

    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\\n1;2;3” => 6)")
    @Test
    void custom_구분자() {
        assertThat(splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }


    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)")
    @Test
    void 음수() {
        assertThatThrownBy(() -> splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수는 허용하지 않습니다.");
    }

    @DisplayName("문자를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)")
    @Test
    void 문자() {
        assertThatThrownBy(() -> splitAndSum("hello"))
                .isInstanceOf(NumberFormatException.class);
    }
}
