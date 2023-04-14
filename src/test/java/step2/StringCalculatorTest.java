package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static step2.StringCalculator.*;

public class StringCalculatorTest {
    @Test
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    void emptyOrNull() {
        // given & when & then
        assertThat(calculate(null)).isEqualTo(0);
        assertThat(calculate("")).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void oneNumber() {
        // given & when & then
        assertThat(calculate("1")).isEqualTo(1);
        assertThat(calculate("10")).isEqualTo(10);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    void twoNumbers() {
        // given & when & then
        assertThat(calculate("1,2")).isEqualTo(3);
        assertThat(calculate("10,21")).isEqualTo(31);
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
    void colon() {
        // given & when & then
        assertThat(calculate("1,2:3")).isEqualTo(6);
        assertThat(calculate("10,21:32")).isEqualTo(63);
    }

    @Test
    @DisplayName("//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    void customDelimiter() {
        // given & when & then
        assertThat(calculate("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.")
    void negative() {
        // given & when & then
        assertThatThrownBy(() -> calculate("-1,20"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수가 입력되었습니다.");
    }

    @Test
    @DisplayName("숫자 이외의 값을 입력할 경우 RuntimeException 예외가 발생해야 한다.")
    void notNumber() {
        // given & when & then
        assertThatThrownBy(() -> calculate("a,b,c"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자가 아니거나 Long 범위를 초과한 수가 입력되었습니다.");
    }

    @Test
    @DisplayName("구분자만 존재하는 경우 0을 반환한다.")
    void onlyDelimiter() {
        // given & when & then
        assertThat(calculate(",")).isEqualTo(0);
        assertThat(calculate(":")).isEqualTo(0);
    }

    @Test
    @DisplayName("Long 타입의 최대값을 초과하는 경우 RuntimeException 예외가 발생해야 한다.")
    void overMaxLong() {
        // given & when & then
        assertThatThrownBy(() -> calculate("9223372036854775808"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자가 아니거나 Long 범위를 초과한 수가 입력되었습니다.");
    }
}
