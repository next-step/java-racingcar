package racewinner.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NameTest {

    @Test
    void create() {
        Name name = new Name("popo");

        assertThat(name).isEqualTo(new Name("popo"));
    }

    @Test
    @
    void nameNullOrEmpty() {
        Name name = new Name("popo");

        assertThat(name).isEqualTo(new Name("popo"));
    }
    @Test
    void create() {
        Name name = new Name("popo");

        assertThat(name).isEqualTo(new Name("popo"));
    }


}