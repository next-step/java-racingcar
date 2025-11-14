package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NonNegativeTest {
    @Test
    void plus() {
       NonNegative result = new NonNegative("3").plus(2);
       assertThat(result).isEqualTo(new NonNegative(5));
    }

    @Test
    void create() {
        assertThat(new NonNegative("3")).isEqualTo(new NonNegative(3));
    }

    @Test
    void 음수() {
        assertThatThrownBy(() -> {
            new NonNegative(-1);
        }).isInstanceOf(RuntimeException.class);
    }
}
