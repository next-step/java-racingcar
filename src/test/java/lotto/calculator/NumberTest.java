package lotto.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTest {

    @DisplayName("숫자 생성")
    @Test
    void create() {
        assertThat(new Number("1")).isEqualTo(new Number(1L));
    }

    @DisplayName("덧셈")
    @Test
    void plus() {
        assertThat(new Number("8").add(new Number("2"))).isEqualTo(new Number("10"));
    }

    @DisplayName("뺄셈")
    @Test
    void minus() {
        assertThat(new Number("8").subtract(new Number("2"))).isEqualTo(new Number("6"));
    }

    @DisplayName("곱셈")
    @Test
    void multiply() {
        assertThat(new Number("8").multiply(new Number("2"))).isEqualTo(new Number("16"));
    }

    @DisplayName("나눗셈")
    @Test
    void divide() {
        assertThat(new Number("8").divide(new Number("2"))).isEqualTo(new Number("4"));
    }
}