package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");

    }

    @Test
    void split2() {
        String[] result = "1,2".split(",");
        assertThat(result[0]).contains("1");
    }

    @Test
    void substring() {
        String[] result = "(1,2)".substring(1, 4)
                                 .split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void charAt() {
        char result = "abc".charAt(0);
        assertThat(result).isEqualTo('a');
    }

    @Test
    void stringIndexOutOfBoundsException() {
        char result = "abc".charAt(4);
//        assertThatExceptionOfType(IndexOutOfBoundsException.class)
//            .isThrownBy(() -> {
//                // ...
//            }).hasMessageMatching("Index: \\d+, Size: \\d+");
    }
}
