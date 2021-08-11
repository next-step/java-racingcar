package edu.nextstep.racingcarwinner.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class NameTest {

    @Test
    void create(){
        // given
        String nameString = "hwan";

        // when
        Name name = new Name(nameString);

        // then
        assertThat(name).isEqualTo(new Name("hwan"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "}) // given
    void invalidEmpty(String nameString) {
        // when, then
        assertThatThrownBy(() -> {
            new Name(nameString);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void invalidNull() {
        // given
        String nameString = null;

        // when, then
        assertThatThrownBy(() -> {
            new Name(nameString);
        }).isInstanceOf(IllegalArgumentException.class);

    }

}