package calculator;

import org.junit.jupiter.api.Test;

import static calculator.Calculator.calc;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CalcTest {

    @Test
    void 빈_문자열_null_처리() {
        assertThat(calc(null)).isEqualTo(0);
        assertThat(calc("")).isEqualTo(0);
    }

    @Test
    void 숫자두개_컴마_합_반환() {
        assertThat(calc("1,2")).isEqualTo(3);
    }
    @Test
    void 숫자하나_반환() {
        assertThat(calc("1")).isEqualTo(1);
    }

    @Test
    void 구분자_컴마_콜론_합_반환() {
        assertThat(calc("1,2:3")).isEqualTo(6);
    }

}
