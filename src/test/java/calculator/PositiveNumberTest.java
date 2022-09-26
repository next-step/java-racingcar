package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PositiveNumberTest {
    @Test
    void create() {
        assertThat(PositiveNumber.of("1")).isEqualTo(PositiveNumber.of(1));
    }

    @Test
    void plus() {
        PositiveNumber positive = PositiveNumber.of(1);
        PositiveNumber result = positive.plus(2);
        assertThat(result).isEqualTo(PositiveNumber.of(3));
    }

    @Test
    void negative() {
        assertThatThrownBy(() -> PositiveNumber.of(-1))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> PositiveNumber.of("-1"))
                .isInstanceOf(RuntimeException.class);
    }
}
