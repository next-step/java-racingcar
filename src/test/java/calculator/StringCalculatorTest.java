package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @DisplayName("null 또는 빈문자열 입력 받을 경우 → 0을 리턴한다.")
    @Test
    void test_1() {
        assertThat(StringCalculator.calculate("")).isEqualTo(0);
        assertThat(StringCalculator.calculate(null)).isEqualTo(0);
    }

    @DisplayName("쉼표로 구분된 숫자의 합을 반환한다  (\"1,2\" → 3)")
    @Test
    void test_2() {
        assertThat(StringCalculator.calculate("1,2")).isEqualTo(3);
        assertThat(StringCalculator.calculate("1,2,3")).isEqualTo(6);
    }

    @DisplayName("숫자 하나만 입력하면 그 숫자를 반환한다 (\"1\" → 1)")
    @Test
    void test_3() {
        assertThat(StringCalculator.calculate("1")).isEqualTo(1);
        assertThat(StringCalculator.calculate("5")).isEqualTo(5);
    }

    @DisplayName("쉼표 또는 콜론으로 구분된 숫자의 합을 반환한다 (\"1,2:3\" → 6)")
    @Test
    void test_4() {
        assertThat(StringCalculator.calculate("1,2:3")).isEqualTo(6);
        assertThat(StringCalculator.calculate("1,2:3,4")).isEqualTo(10);
    }

    @DisplayName("\"//\"와 \"\\n\" 사이의 커스텀 구분자로 구분된 숫자의 합을 반환한다 (\"//;\\n1;2;3\" → 6)")
    @Test
    void test_5() {
        assertThat(StringCalculator.calculate("//;\n1;2;3")).isEqualTo(6);
        assertThat(StringCalculator.calculate("//?\n1?2?3")).isEqualTo(6);
    }

    @DisplayName("음수가 포함되면 RuntimeException (\"-1,2\")")
    @Test
    void test_6() {
        assertThatThrownBy(() -> StringCalculator.calculate("-1,2"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수");
    }

    @DisplayName("숫자 이외의 값이 포함되면 RuntimeException (\"a,1\")")
    @Test
    void test_7() {
        assertThatThrownBy(() -> StringCalculator.calculate("a,1"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자 이외의 값");
    }

}
