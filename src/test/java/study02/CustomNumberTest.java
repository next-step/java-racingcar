package study02;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomNumberTest {

    @Test
    void create() {
        assertThat(new CustomNumber("5")).isEqualTo(new CustomNumber(5));
    }

    @Test
    void 덧셈() {
        assertThat(new CustomNumber("2").plus(new CustomNumber(3))).isEqualTo(new CustomNumber(5));
    }

    @Test
    void 뺄셈() {
        assertThat(new CustomNumber("1").minus(new CustomNumber(2))).isEqualTo(new CustomNumber("-1"));
    }

    @Test
    void 곱셈() {
        assertThat(new CustomNumber("1").times(new CustomNumber(2))).isEqualTo(new CustomNumber(2));
    }

    @Test
    void 나눗셈() {
        assertThat(new CustomNumber("4").dividedBy(new CustomNumber(2))).isEqualTo(new CustomNumber(2));
        assertThatThrownBy(() -> {
            new CustomNumber("4").dividedBy(new CustomNumber(0));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}