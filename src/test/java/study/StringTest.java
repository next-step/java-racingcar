package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("콤마를 기준으로 분리한다.")
    void splitByComma() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("괄호를 제거한다.")
    void trimParentheses() {
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 올바르게 가져오는지 확인")
    void charAt() {
        assertThat("abc".charAt(0)).isEqualTo('a');
        assertThat("abc".charAt(1)).isEqualTo('b');
        assertThat("abc".charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> {
            "abc".charAt(-1);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
