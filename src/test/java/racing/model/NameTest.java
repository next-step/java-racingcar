package racing.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    void 유효성() {
        assertThat(new Name("12345").getName()).isEqualTo("12345");
        assertThatThrownBy(() -> {
            new Name("123456");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}