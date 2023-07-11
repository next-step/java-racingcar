package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"p", "pobii"})
    void Name생성할때_성공(String text) {
        // when
        final Name name = Name.from(text);

        // then
        assertThat(name.getValue()).isEqualTo(text);
    }

    @Test
    void 비었거나null인이름일때_생성실패_RuntimeException발생() {
        // given
        final String text1 = "";
        final String text2 = null;

        // when & then
        assertThatThrownBy(() -> Name.from(text1)).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> Name.from(text2)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 정해진길이보다긴이름일때_생성실패_RuntimeException발생() {
        // given
        final String text = "aaaaaa";

        // when & then
        assertThatThrownBy(() -> Name.from(text)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 같은이름을가질때_같은객체로판단성공() {
        // given
        final String text = "pobi";
        final Name name1 = Name.from(text);
        final Name name2 = Name.from(text);

        // when & then
        assertThat(name1).isEqualTo(name2);
    }

    @Test
    void 다른이름을가질때_다른객체로판단성공() {
        // given
        final String text1 = "pobi";
        final String text2 = "crong";
        final Name name1 = Name.from(text1);
        final Name name2 = Name.from(text2);

        // when & then
        assertThat(name1).isNotEqualTo(name2);
    }
}