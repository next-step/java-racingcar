package calculator;

import org.junit.jupiter.api.Test;

import static calculator.StringAddCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveNumberTest {

    @Test
    void 양수객체생성() {
        assertThat(new PositiveNumber("1")).isEqualTo(new PositiveNumber(1));
    }

    @Test
    void 덧셈() {
        assertThat(new PositiveNumber("1").plus(new PositiveNumber("2"))).isEqualTo(new PositiveNumber(3));
    }

    @Test
    void 음수() {
        assertThatThrownBy(() -> splitAndSum("-1")).isInstanceOf(RuntimeException.class);
    }

}
