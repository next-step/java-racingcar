package study;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void subString() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Nested
<<<<<<< HEAD
    class testCharAt {
=======
    class CharAtTest {
>>>>>>> 2f563663486c84b8f8713cec53bc3ef69d1d9355
        @Test
        void charAt() {
            char result = "abc".charAt(0);
            assertThat(result).isEqualTo('a');
        }
        @Test
        void indexOutOfBounds() {
            String data = "abc";
            int idx = 10;
            assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
<<<<<<< HEAD
                    .isThrownBy(() -> {
                        data.charAt(idx);
                    }).withMessageMatching("String index out of range: " + idx);
=======
                    .isThrownBy(() -> data.charAt(idx))
                    .withMessageMatching("String index out of range: " + idx);
>>>>>>> 2f563663486c84b8f8713cec53bc3ef69d1d9355
        }
    }
}
