package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    void create_valid() {
        assertThat(new Name("j")).isEqualTo(new Name("j"));
        assertThat(new Name("jason")).isEqualTo(new Name("jason"));
    }

    @Test
    void create_invalid() {
        assertThatThrownBy(() -> new Name(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Name("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Name("javaji")).isInstanceOf(IllegalArgumentException.class);
    }
}
