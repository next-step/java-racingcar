package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

class PositiveIntegerTest {

    @Test
    void nullOrSpace() {
        assertThat(new PositiveInteger(null)).isEqualTo(new PositiveInteger("0"));
        assertThat(new PositiveInteger("")).isEqualTo(new PositiveInteger("0"));
        assertThat(new PositiveInteger(" ")).isEqualTo(new PositiveInteger("0"));
    }

    @Test
    void nonNumericOrMinus() {
        assertThatThrownBy(() -> new PositiveInteger("TDD")).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> new PositiveInteger("-1")).isInstanceOf(RuntimeException.class);
    }

    @Test
    void equals() {
        assertThat(new PositiveInteger("1")).isEqualTo(new PositiveInteger("1"));
    }

}