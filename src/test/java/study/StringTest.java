package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
        String[] anotherResult = "1".split(",");
        assertThat(anotherResult).contains("1");
    }

    @Test
    void substring() {
        String data = "(1,2)";
        String result = data.substring(1, data.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("인덱스를 넘어가면 Exception 이 발생한다.")
    void indexOutOfBoundsException() {
        String data = "abc";
        assertThat(data.charAt(0)).isEqualTo('a');
        assertThatThrownBy(() -> data.charAt(3)).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
