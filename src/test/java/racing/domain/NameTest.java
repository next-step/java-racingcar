package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NameTest {
    @Test
    void length5NameSuccessTest() {
        Name name = new Name("testt");

        assertThat(name).isEqualTo(new Name("testt"));
    }

    @Test
    void length6NameThrowsRuntimeExceptionTest() {
        assertThrows(RuntimeException.class, () -> {
            new Name("testtt");
        });
    }
}