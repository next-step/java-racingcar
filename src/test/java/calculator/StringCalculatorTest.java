package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @DisplayName("null 또는 빈문자열 입력 받을 경우 → 0을 리턴한다.")
    @Test
    void test_1() {
        Assertions.assertThat(StringCalculator.calculate("")).isEqualTo(0);
        Assertions.assertThat(StringCalculator.calculate(null)).isEqualTo(0);
    }

    @DisplayName("쉼표로 구분된 숫자의 합을 반환한다  (\"1,2\" → 3)")
    @Test
    void test_2() {
        Assertions.assertThat(StringCalculator.calculate("1,2")).isEqualTo(3);
        Assertions.assertThat(StringCalculator.calculate("1,2,3")).isEqualTo(6);
    }

    @DisplayName("숫자 하나만 입력하면 그 숫자를 반환한다 (\"1\" → 1)")
    @Test
    void test_3() {
        Assertions.assertThat(StringCalculator.calculate("1")).isEqualTo(1);
        Assertions.assertThat(StringCalculator.calculate("5")).isEqualTo(5);
    }



}
