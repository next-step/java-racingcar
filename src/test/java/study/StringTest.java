package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class StringTest {
    @Test
    @DisplayName("String split 확인")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("String subSting 확인")
    void subString() {
        String originalText = "(1,2)";
        String result = originalText.substring(originalText.indexOf("(") + 1, originalText.indexOf(")"));
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String charAt 정상동작 확인")
    void charAt() {
        String text = "abc";
        assertAll(
                () -> assertThat(text.charAt(0)).isEqualTo('a'),
                () -> assertThat(text.charAt(1)).isEqualTo('b'),
                () -> assertThat(text.charAt(2)).isEqualTo('c')
        );
    }

    @Test
    @DisplayName("String charAt indexOutOfBound 확인")
    void charAtIndexOutBound() {
        String text = "abc";
        assertThatThrownBy(() -> text.charAt(text.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining(String.format("String index out of range: %d", text.length()));
    }
}
