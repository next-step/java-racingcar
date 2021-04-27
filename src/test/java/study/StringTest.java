package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void test() {
        final String[] actual = "1,2".split(",");

//        assertThat(actual).contains("1","2");
//        assertThat(actual).contains(actual);
//        assertThat(actual).contains(actual);
//        assertThat(actual).containsExactly(actual);
        this.name();
        this.name2();

    }

    // Alt + Insert = method add
    @Test
    void name() {
        final String actual2 = "(1,2)".replace("(", "")
                .replace(")", "");
        assertThat(actual2).contains("1,2");
    }

    @DisplayName("String request")
    @Test
    void name2() {
        final String actual = "abc";
        assertThatThrownBy(() -> {
            actual.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}