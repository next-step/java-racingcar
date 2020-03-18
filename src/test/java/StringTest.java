import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;

public class StringTest {

    @Test
    void split1() {
        String[] input = "1,2".split(",");
        assertThat(input).contains("1", "2");
    }

    @Test
    void split2() {
        String[] input = "1".split(",");
        assertThat(input).containsExactly("1");

    }

    @Test
    void substring() {
        String input = "(1,2)";
        String result = input.substring(1, input.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void chatAt() {
        String input = "abc";
        assertThatThrownBy(() -> {
            input.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }




}
