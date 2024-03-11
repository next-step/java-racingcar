package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    void create() {
        Name name = new Name("이름없음");
        assertThat(name).isEqualTo(new Name("이름없음"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void nullAndEmptyName(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 5자를 초과하면 예외를 던진다")
    @Test
    void exceedNameLength() {
        assertThatThrownBy(() -> new Name("tester"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
