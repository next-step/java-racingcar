package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author : yusik
 * @date : 2019/10/24
 */
public class StringTest {

    @Test
    void split() {
        String[] result = "1,2,3".split(",");
        assertThat(result).hasSize(3);
        assertThat(result).contains("1", "3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        assertThatThrownBy(() -> {
            char result = "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
