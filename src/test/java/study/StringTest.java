package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split() {
        String[] splitText = "1,2".split(",");
        assertThat(splitText).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String text = "(1,2)";
        String substringText = text.substring(1, text.length() - 1);
        assertThat(substringText).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        String text = "abc";
        assertThat(text.charAt(0)).isEqualTo('a');
        assertThat(text.charAt(1)).isEqualTo('b');
        assertThat(text.charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> {
            text.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: 3");

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                text.charAt(3);
            }).withMessageMatching("String index out of range: \\d+");
    }
}
