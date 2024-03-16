package race.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NameTest {

    @Test
    void nameTest() {
        assertThat(new Name("임형준")).isEqualTo(new Name("임형준"));
    }

}
