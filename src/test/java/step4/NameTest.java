package step4;

import org.junit.jupiter.api.Test;
import step4.model.Name;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    void create() {
        assertThat(new Name("pobi")).isEqualTo(new Name("pobi"));
    }

    @Test
    void invalid() {
        assertThatThrownBy(() -> new Name(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Name("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Name("punsoo")).isInstanceOf(IllegalArgumentException.class);
    }
}