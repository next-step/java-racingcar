package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] values = "1,2".split(",");
        assertThat(values).contains("1", "2");
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String value = "(1,2)";
        String result = value.substring(1, value.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("\"abc\" 문자열이 주어지면, charAt 메소드를 이용해 특정 위치의 문자를 가져올 수 있다. chatAt(0)=a, charAt(1)=b, charAt(2)=c")
    @Test
    void charAt() {
        String value = "abc";
        assertThat(value.charAt(0)).isEqualTo('a');
        assertThat(value.charAt(1)).isEqualTo('b');
        assertThat(value.charAt(2)).isEqualTo('c');
    }

    @DisplayName("\"abc\" 문자열이 주어지면, charAt 메소드를 이용해 특정 위치의 문자를 가져올 수 있다. chatAt(3), chatAt(-1)을 호출하면 StringIndexOutOfBoundsException이 발생한다.")
    @Test
    void chatAt_IndexOutOfBoundsException() {
        String value = "abc";
        assertThatThrownBy(() -> value.charAt(3)).isInstanceOf(IndexOutOfBoundsException.class);
        assertThatThrownBy(() -> value.charAt(-1)).isInstanceOf(IndexOutOfBoundsException.class);
    }

}
