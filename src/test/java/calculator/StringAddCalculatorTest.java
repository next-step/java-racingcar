package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.StringAddCalculator.calculate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {
    @Test
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환한다.")
    void test_null_or_empty()  {
        assertThat(calculate("")).isEqualTo(0);
        assertThat(calculate(null)).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void test_number() {
        assertThat(calculate("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    void test_numbers_sum() {
        assertThat(calculate("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
    void test_split_colon() {
        assertThat(calculate("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName(" //와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    void test_custom_split() {
        assertThat(calculate("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.")
    void test_negative() {
        assertThatThrownBy(() -> calculate("-1,2,3")).isInstanceOf(RuntimeException.class);
    }
}
