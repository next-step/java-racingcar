package game.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    @DisplayName("이름이 null 또는 empty")
    void name_is_null_or_empty() {
        assertThatThrownBy(() -> {
            new Name(null);
        }).isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> {
            new Name("");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("이름이 5글자를 초과")
    void name_is_larger_than_5() {
        assertThatThrownBy(() -> {
            new Name("123456");
        }).isInstanceOf(RuntimeException.class);
    }
}