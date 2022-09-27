package test2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PositiveTest {

    @Test
    void create() {
        assertThat(new Positive("1")).isEqualTo(new Positive(1));
    }

    @Test
    void 덧셈() {
        Positive positive = new Positive("1").plus(new Positive(2));
        assertThat(positive).isEqualTo(new Positive(3));
    }

    @Test
    void 음수() {
        assertThatThrownBy(() -> {
            new Positive("-1");
        }).isInstanceOf(RuntimeException.class);
    }
}
