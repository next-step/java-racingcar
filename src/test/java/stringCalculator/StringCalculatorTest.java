package stringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static stringCalculator.StringCalculator.calculate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Disabled("사칙 연산 기호가 아닌 경우 Exception throw")
    @Test
    void 사칙연산_기호가_아닌_경우_에러() {
        assertThatThrownBy(() -> {
            calculate("3 & 1");
        }).isNotInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 계산() {
        assertThat(calculate("1 + 2 * 3 / 4")).isEqualTo(2);
    }

    @Test
    void 덧셈(){
        assertThat(calculate("3 + 1")).isEqualTo(4);
    }

    @Test
    void 뺌셈(){
        assertThat(calculate("3 - 1")).isEqualTo(2);
    }

    @Test
    void 곱셈(){
        assertThat(calculate("3 * 1")).isEqualTo(3);
    }

    @Test
    void 나눗셈(){
        assertThat(calculate("4 / 2")).isEqualTo(2);
    }



}
