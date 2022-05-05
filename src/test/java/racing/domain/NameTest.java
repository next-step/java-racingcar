package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NameTest {

    @Test
    void 자동차_이름() {
        Name name = new Name("car");
        assertThat(name.toString()).isEqualTo("car");
    }

    @Test
    void 자동차_이름_길이_오류() {
        assertThrows(IllegalArgumentException.class, () -> new Name("longName"));
    }
}