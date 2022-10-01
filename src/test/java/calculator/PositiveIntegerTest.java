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
    void numericIntAndString() {
        assertThat(new PositiveInteger("1")).isEqualTo(new PositiveInteger("1"));
        assertThat(new PositiveInteger("1")).isEqualTo(new PositiveInteger(1));
        assertThat(new PositiveInteger(1)).isEqualTo(new PositiveInteger("1"));
        assertThat(new PositiveInteger(1)).isEqualTo(new PositiveInteger(1));
    }

    @Test
    void plus() {
        PositiveInteger one = new PositiveInteger("1");
        assertThat(one.plus(new PositiveInteger("2"))).isEqualTo(new PositiveInteger("3"));
        // assert that "one" is immutable even after add operation
        assertThat(one).isEqualTo(new PositiveInteger("1"));
    }
}