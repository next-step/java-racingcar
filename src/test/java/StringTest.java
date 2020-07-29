import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split() {
        String[] values = "1,2".split(",");
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    void subString() {
        String result = "(1,2)".substring(1, 4); //start inbound, end outbound
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        char c = "abc".charAt(0);
        assertThat(c).isEqualTo('a');
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}