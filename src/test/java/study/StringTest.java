package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String data1 = "1,2";
        String[] result = data1.split(",");
        assertThat(result).containsExactly("1","2");

        String data2 = "1";
        String[] result2 = data2.split(",");
        assertThat(result2).contains("1");
    }

    @Test
    void substring() {
        String str = "(1,2)";
        str = str.substring(1,4);
        assertThat(str).isEqualTo("1,2");
    }

    @Test
    void charAtTest() {
        String str = "abc";
        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
    }

    @DisplayName("charAt사용시 index범위를 벗어나면 IndexOutofBoundsException발생")
    @Test
    void charAtExceptionTest() {
        String str = "abc";

        assertThatThrownBy(() -> {
            str.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 3");
    }
}
