package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAsNamesTest {
    @Test
    void names() {
        StringAsNames sut = new StringAsNames("pobi,crong");
        assertThat(sut.names()).containsExactly(new Name("pobi"), new Name("crong"));
    }
}
