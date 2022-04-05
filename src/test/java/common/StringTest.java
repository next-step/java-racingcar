package common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split은_regex로_문자열을_분할해서_배열로_반환한다() {
        String[] expected = {"1", "2"};
        String[] result = "1,2".split(",");
        assertThat(result).contains(expected);
    }

    @Test
    void split은_regex로_매치되지_않으면_문자열을_포함한_배열을_반환한다() {
        String expected = "1";
        String[] result = "1".split(",");
        assertThat(result).containsExactly(expected);
    }

    @Test
    void subString은_index에_포함되는_문자열을_반환한다() {
        String expected = "1,2";
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void charAt은_index위치의_char를_반환한다() {
        char expected = 'a';
        char result = "abc".charAt(0);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("charAt은_index_위치가_값을_벗어나면_IndexOutOFBounds_예외를_발생시킨다")
    void charAt은_index_위치가_값을_벗어나면_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            char result = "abc".charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
