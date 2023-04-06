import org.assertj.core.api.AbstractThrowableAssert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("String class split test")
    void splitTest() {
        final String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly("1", "2");

        String[] actual1 = "1".split(",");
        assertThat(actual1).containsExactly("1");
    }

    @Test
    @DisplayName("String class substring test")
    void substringTest() {
        String target = "(1,2)";
        String actual = target.substring(target.indexOf("(") + 1, target.indexOf(")"));
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String class charAt method test")
    void charAtTest() {
        String target = "abc";
        char actual = "abc".charAt(0);

        assertThat(actual).isEqualTo('a');

        assertThatThrownBy(() -> target.charAt(target.length() + 1)).isInstanceOf(StringIndexOutOfBoundsException.class);

    }

}
