package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PositiveNumberTest {
    @Test
    void create() {
        assertThat(PositiveNumber.from("1")).isEqualTo(PositiveNumber.from(1));
    }

    @Test
    void plus() {
        PositiveNumber positive = PositiveNumber.from(1);
        PositiveNumber result = positive.plus(2);
        assertThat(result).isEqualTo(PositiveNumber.from(3));
    }

    @Test
    void negative() {
        assertThatThrownBy(() -> PositiveNumber.from(-1))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> PositiveNumber.from("-1"))
                .isInstanceOf(RuntimeException.class);
    }
}
