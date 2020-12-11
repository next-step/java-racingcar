package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class StringTest {

    @Test
    public void testSplit() {
        String text = "1,2";
        String[] strings = text.split(",");
        assertThat(strings[0]).isEqualTo("1");
        assertThat(strings[1]).isEqualTo("2");
        assertThat(strings).containsExactly("1", "2");

        String text2 = "1";
        String[] strings2 = text2.split(",");
        assertThat(strings2[0]).isEqualTo("1");
        assertThat(strings2.length).isEqualTo(1);
    }

    @Test
    public void testSubString() {
        String text = "(1,2)";
        String subStringText = text.substring(1, 4);
        assertThat(subStringText).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 테스트, 인덱스를 벗어나는 경우 exception")
    public void testCharAt() {
        String text = "abc";
        assertThat(text.charAt(0)).isEqualTo('a');
        assertThat(text.charAt(1)).isEqualTo('b');
        assertThat(text.charAt(2)).isEqualTo('c');
        assertThatThrownBy(() -> {
            text.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

}
