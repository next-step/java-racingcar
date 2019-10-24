package study;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void split() {
        assertThat("1,2".split(",")).containsExactly("1","2");
        assertThat("1".split(",")).contains("1");
    }

    @Test
    void substring() {
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    void throwTest() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 2, Size: 2");
    }
}
