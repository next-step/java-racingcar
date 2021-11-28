package study.racinggame.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NamesTest {
    @Test
    @DisplayName("주어진 스트링 값으로 Name 객체 리스트를 만든다")
    void shouldCreateWithSameValue() {
        Name pobi = new Name("pobi");
        Name conan = new Name("conan");
        Name jake = new Name("jake");
        Names names = new Names("pobi,conan,jake");

        assertThat(names.getNames()).containsExactly(pobi, conan, jake);
    }
}