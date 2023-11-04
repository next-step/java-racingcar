package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.Calculator.cal;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class calTest {

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생한다.")
    void 음수_RuntimeException_예외_발생(){
        assertThatThrownBy(() -> {
            assertThat(cal("-1:2:3"));
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("\"//\"와 \"\\n\" 문자 사이에 지정한 커스텀 구분자로 숫자의 합을 반환한다.")
    void 커스텀_구분자(){
        assertThat(cal("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("컴마(,) 이외에 콜론(:) 구분자로 입력할 경우 숫자의 합을 반환한다.")
    void 콜론_구분자(){
        assertThat(cal("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    void 컴마_구분자(){
        assertThat(cal("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void 숫자_하나(){
        assertThat(cal("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환한다.")
    void null_빈문자열_값(){
        assertThat(cal(null)).isEqualTo(0);
        assertThat(cal("")).isEqualTo(0);
    }
}
