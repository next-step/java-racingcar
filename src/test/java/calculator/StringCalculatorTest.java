package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    @Test
    @DisplayName("양수값이 들어오면, 양수값을 더한값을 반환한다.")
    void test1() {
        assertThat(StringCalculator.sum("1,2")).isEqualTo(3);
        assertThat(StringCalculator.sum("1,2,3")).isEqualTo(6);
        assertThat(StringCalculator.sum("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("양수이외의 값이 들어오면, IllegalArgumentException을 던진다.")
    void test2() {
        assertThatThrownBy(() -> StringCalculator.sum("a:1")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> StringCalculator.sum("-1:1")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Blank, Null값이 들어오면, 0을 반환한다.")
    void test3() {
        assertThat(StringCalculator.sum("")).isZero();
    }

}
