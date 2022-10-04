package carracing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    void NULL_이름() {
        assertThatThrownBy(() -> {
            new Name(null);
        }).isInstanceOf(NullPointerException.class);
    }

    @Test
    void 이름길이_5_초과() {
        assertThatThrownBy(() -> {
            new Name("123456");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
