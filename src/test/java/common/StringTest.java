package common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Java String class의")
public class StringTest {
    @Test
    @DisplayName("split은 regex로 문자열을 분할해서 배열로 반환한다. regex로 매치되지 않으면 문자열을 포함한 배열을 반환한다.")
    void split은_regex로_문자열을_분할해서_배열로_반환한다() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    void subString은_index에_포함되는_문자열을_반환한다() {
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    void charAt은_index위치의_char를_반환한다() {
        assertThat("abc".charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt은_index_위치가_값을_벗어나면_IndexOutOFBounds_예외를_발생시킨다")
    void charAt은_index_위치가_값을_벗어나면_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            "abc".charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
