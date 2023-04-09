package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void stringClass1() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void stringClass2() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).contains("1,2");
    }

    @Test
    void stringClass3() {
        String abc = "abc";
        char a = abc.charAt(0);
        char b = abc.charAt(1);
        char c = abc.charAt(2);

        assertThat(a).isEqualTo('a');
        assertThat(b).isEqualTo('b');
        assertThat(c).isEqualTo('c');

        assertThatThrownBy( () -> abc.charAt(3)) .isInstanceOf(IndexOutOfBoundsException.class).hasMessageContainingAll("String index out of range: 3");
    }
}
