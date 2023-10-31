package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("한 단어 split")
    @Test
    void splitOnlyOne() {
        String[] result = "1".split(",");
        assertThat(result).isEqualTo("1");
    }

    @DisplayName("처음, 끝 substring 후 split")
    @Test
    void splitWithSubstring() {
        String data = "(1,2)";
        String[] result = data.substring(1, data.length()-1).split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("charAt 첫 인덱스")
    @Test
    void charAtStartIndex() {
        char result = "abc".charAt(0);
        assertThat(result).isEqualTo('a');
    }

    @DisplayName("charAt 마지막 인덱스")
    @Test
    void charAtLastIndex() {
        String data = "abc";
        char result = data.charAt(data.length()-1);
        assertThat(result).isEqualTo('c');
    }

    @DisplayName("charAt 범위 내")
    @Test
    void charAtInOfBound() {
        char result = "abc".charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @DisplayName("charAt 범위 밖")
    @Test
    void charAtOutOfBound() {
        assertThatThrownBy(() -> {
            char result = "abc".charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
