package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void test() {
        Assertions.assertEquals(8, 3 + 5);

        assertThat(3 + 5).isEqualTo(8);
    }

    @Test
    void test1() {
        final String[] actual = "1,2".split(",");
        assertThat(actual).contains("1");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void test2() {
        final String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");

        String actual2 = "(1,2)";
        actual2 = actual2.replaceAll("\\(", "");
        actual2 = actual2.replaceAll("\\)", "");
        assertThat(actual2).isEqualTo("1,2");
    }

    @Test
    void test3() {
        String actual = Character.toString("abc".charAt(4));
        assertThat(actual).isEqualTo("a");
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    // ...
                }).withMessageMatching("Index: \\d+, Size: \\d+");
    }
}
