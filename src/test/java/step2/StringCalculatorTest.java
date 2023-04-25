package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;
import static step2.StringCalculator.*;

public class StringCalculatorTest {
    @ParameterizedTest
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @NullAndEmptySource
    void emptyOrNull(String text) {
        // given & when & then
        assertThat(calculate(text)).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @CsvSource(value = {"1,1", "10,10"})
    void oneNumber(String text, int expected) {
        // given & when & then
        assertThat(calculate(text)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @CsvSource(value = {"1,2|3", "10,21|31"}, delimiter = '|')
    void twoNumbers(String input, int expected) {
        // given & when & then
        assertThat(calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
    @CsvSource(value = {"1,2:3|6", "10,21:32|63"}, delimiter = '|')
    void colon(String input, int expected) {
        // given & when & then
        assertThat(calculate(input)).isEqualTo(expected);
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
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @DisplayName("구분자만 존재하는 경우 0을 반환한다.")
    @CsvSource(value = {",|0",":|0"}, delimiter = '|')
    void onlyDelimiter(String input, int expected) {
        // given & when & then
        assertThat(calculate(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("int 타입의 최대값을 초과하는 경우 RuntimeException 예외가 발생해야 한다.")
    void overMaxLong() {
        // given & when & then
        assertThatThrownBy(() -> calculate("2147483647,1"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("합이 int 범위를 초과한 수가 입력되었습니다.");
    }
}
