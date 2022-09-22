package calculator;

import org.junit.jupiter.api.Test;

import static calculator.StringAddCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveTest {

    @Test
    void 양수객체생성() {
        assertThat(new Positive("1")).isEqualTo(new Positive(1));
    }

    @Test
    void 덧셈() {
        assertThat(new Positive("1").plus(new Positive(2))).isEqualTo(new Positive(3));
    }

    @Test
    void 음수() {
        assertThatThrownBy(() -> splitAndSum("-1")).isInstanceOf(RuntimeException.class);
    }

}
