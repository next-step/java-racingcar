package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PositiveNumberTest {
    @Test
    void create() {
        assertThat(new PositiveNumber("1")).isEqualTo(new PositiveNumber(1));
    }

    @Test
    void 덧셈() {
        PositiveNumber positive = new PositiveNumber("1");
        PositiveNumber result = positive.plus(2);
        assertThat(result).isEqualTo(new PositiveNumber(3));
    }
    @Test
    void 음수() {
        assertThatThrownBy(
                () -> {
                    new PositiveNumber("-1");
                }
        ).isInstanceOf(RuntimeException.class);
    }
}
