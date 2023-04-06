package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class StringTest {
    @Test
    @DisplayName("요구사항 1")
    void split() {
        String data = "1,2";
        assertThat(data.split(",")).contains("1", "2");

        data = "1";
        assertThat(data.split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2")
    void substring() {
        String data = "(1,2)";
        assertThat(data.substring(1,4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3")
    void charAt() {
        String data = "abc";
        assertThat(data.charAt(0)).isEqualTo('a');
        assertThat(data.charAt(1)).isEqualTo('b');
        assertThat(data.charAt(2)).isEqualTo('c');
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    data.charAt(3);
                }).withMessageContaining("index out of range");
    }
}
