package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NameTest {

    @Test
    void create () {
        Name name = new Name("hyeon");
        assertThat(name).isEqualTo(new Name("hyeon"));
    }

    @Test
    void valid () {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Name(null)).withMessageMatching("null값을 입력할 수 없습니다.");
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Name(" ")).withMessageMatching("빈값을 입력할 수 없습니다.");
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Name("abcdef")).withMessageMatching("이름은 5자를 넘을 수 없습니다.");
    }
}
