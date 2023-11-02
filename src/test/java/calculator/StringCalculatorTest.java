package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void calculate_null() {
        assertThat(StringCalculator.calculate(null)).isEqualTo(0);
    }

    @Test
    void calculate_빈_문자열() {
        assertThat(StringCalculator.calculate("")).isEqualTo(0);
    }

    @Test
    void calculate_숫자_한개() {
        assertThat(StringCalculator.calculate("1")).isEqualTo(1);
    }

    @Test
    void calculate_기본_구분자() {
        assertThat(StringCalculator.calculate("1,2")).isEqualTo(3);
        assertThat(StringCalculator.calculate("1,2,3")).isEqualTo(6);
        assertThat(StringCalculator.calculate("1,2:3")).isEqualTo(6);
    }

    @Test
    void calculate_커스텀_구분자() {
        assertThat(StringCalculator.calculate("//;\n1;2;3")).isEqualTo(6);
        assertThat(StringCalculator.calculate("//;::\n1;::2;::3")).isEqualTo(6);
    }

    @Test
    void calculate_기본_구분자_숫자이외의_값() {
        Assertions.assertThatThrownBy(
                () -> StringCalculator.calculate("1,2,a")).isInstanceOf(RuntimeException.class);
    }

    @Test
    void calculate_기본_구분자_음수값() {
        Assertions.assertThatThrownBy(
                () -> StringCalculator.calculate("1,2,-1")).isInstanceOf(RuntimeException.class);
    }
}
