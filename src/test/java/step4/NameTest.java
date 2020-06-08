package step4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    void create() {
        Name peter = new Name("peter");
        assertThat(peter).isEqualTo(new Name("peter"));
    }

    @Test
    void name_is_valid() {
        assertThatThrownBy(() -> new Name("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Name(null)).isInstanceOf(IllegalArgumentException.class);
    }
}