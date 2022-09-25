package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PositiveTest {
    @Test
    void create() {
        assertThat(new Positive("1")).isEqualTo(new Positive(1));
    }

    @Test
    void plus() {
        Positive positive = new Positive("1");
        Positive result = positive.plus(2);
        assertThat(result).isEqualTo(new Positive(3));
    }

    @Test
    void negative() {
        assertThatThrownBy(() -> new Positive(-1))
                .isInstanceOf(RuntimeException.class);
    }
}
