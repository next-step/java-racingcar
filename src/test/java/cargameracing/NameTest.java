package cargameracing;

import cargameracing.domain.Name;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    void nameLength() {
        assertThatThrownBy(()->{
            new Name("avante");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
