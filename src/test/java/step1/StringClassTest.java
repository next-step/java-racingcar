package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringClassTest {

    @Test
    @DisplayName("step 1 - split test")
    void splitTest() {
        String str = "1,2";
        String[] result = str.split(",");
        assertThat(result).contains("1", "2");

        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("step 2 - substring test")
    void substringTest() {
        String str = "(1,2)";
        String result = str.substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }


    @Test
    @DisplayName("step 3 - charAt test")
    void charAtTest() {
        String str = "abc";

        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> str.charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 2, size: 2");
    }
}
