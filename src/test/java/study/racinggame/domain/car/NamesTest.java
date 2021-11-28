package study.racinggame.domain.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NamesTest {
    @Test
    void shouldCreateWithSameValue() {
        Name pobi = new Name("pobi");
        Name conan = new Name("conan");
        Name jake = new Name("jake");
        Names names = new Names("pobi,conan,jake");

        assertThat(names.getNames()).containsExactly(pobi, conan, jake);
    }
}