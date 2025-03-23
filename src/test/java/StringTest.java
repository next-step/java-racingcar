import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split1() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
    }

    @Test
    void split2() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void subString() {
        String data = "(1,2)";
        String result = data.substring(1, data.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        String data = "abc";
        char result = data.charAt(0);
        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("범위를 벗어난 인덱스 접근 시 StringIndexOutOfBoundsException 이 발생해야 한다.")
    void charAt2() {
        String data = "abc";
        assertThatThrownBy(() -> data.charAt(data.length())).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range:");
    }
}
