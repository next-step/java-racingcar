package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void split() {
        String[] data = "1,2".split(",");
        assertThat(data).contains("1");
        assertThat(data).containsExactly("1", "2");
    }

    @Test
    void substring()
    {
        String data = "(1,2)".substring(1,4);
        assertThat(data).isEqualTo("1,2");
    }

    @DisplayName("Index Error Check")
    @Test
    void charAt()
    {
        String data = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    data.charAt(3);
                }).withMessageMatching("String index out of range: 3");
    }
}
