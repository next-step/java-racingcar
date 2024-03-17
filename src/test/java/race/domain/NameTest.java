package race.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    void name_생성() {
        Name name = new Name("pobi");
        assertThat(name).isEqualTo(new Name("pobi"));
    }

    @Test
    void name_null_값() {
        assertThatThrownBy(
                () -> new Name("")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void name_길이() {
        assertThatThrownBy(
                () -> new Name("abcdef")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
