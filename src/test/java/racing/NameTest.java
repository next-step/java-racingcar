package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NameTest {
    @Test
    void 생성() {
        Name name = new Name("apple");
        assertThat(name.getName()).isEqualTo("apple");
    }
}