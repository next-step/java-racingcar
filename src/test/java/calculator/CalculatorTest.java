package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 새로운기능을 구현할때마다 리펙토링
 * 절대 실패하는 코드를 작성하기 전에 product코드 만들면안됨
 */
public class CalculatorTest {

    @Test
    void 올바르지않은입력_런타임에러(){
        assertThatThrownBy(()->Calculator.cal("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
    @Test
    void 커스텀_구분자() {
        assertThat(Calculator.cal("//;\n1;2;3")).isEqualTo(6);
    }
    @Test
    void 콜론_구분자() {
        assertThat(Calculator.cal("1:2")).isEqualTo(3);
    }
    @Test
    void 컴마_구분자() {
        assertThat(Calculator.cal("1,2")).isEqualTo(3);
    }

    @Test
    void 숫자_하나() {
        assertThat(Calculator.cal("1")).isEqualTo(1);
    }
    @Test
    void null_빈문자열_값() {
        assertThat(Calculator.cal(null)).isEqualTo(0);
        assertThat(Calculator.cal("")).isEqualTo(0);
    }
}
