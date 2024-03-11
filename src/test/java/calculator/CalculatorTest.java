package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @DisplayName("커스텀 구분자-//와 \n 사이의 문자가 구분자인 경우-를 전달하여 확인하기")
    @Test
    void 커스텀_구분자_전달() {
        assertThat(Calculator.calculate("//;\n3;6;9")).isEqualTo(18);
    }

    @DisplayName("문자열 계산기에 음수 전달시 예외")
    @Test
    void 음수_전달() {

        //음수 전달시 정상적으로 음수를 인식하여 계산하는 것을 확인함.
        //assertThat(Calculator.calculate("-1,2,-3")).isEqualTo(-2);

        assertThatThrownBy(() -> Calculator.calculate("-1,2,-3"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("문자열 계산기에 숫자 이외의 값 전달시 예외")
    @Test
    void 숫자_이외_전달(){
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> Calculator.calculate("a,b,c"));
    }

    @Test
    void 콜론_콤마_구분자() {
        assertThat(Calculator.calculate("1,2:3")).isEqualTo(6);
    }

    @Test
    void 콜론_구분자() {
        assertThat(Calculator.calculate("1:2")).isEqualTo(3);
    }

    @Test
    void 콤마_구분자() {
        assertThat(Calculator.calculate("1,2")).isEqualTo(3);
    }

    @Test
    void 문자_하나() {
        assertThat(Calculator.calculate("1")).isEqualTo(1);
    }

    @Test
    void null_값() {
        assertThat(Calculator.calculate(null)).isEqualTo(0);
    }
}
