package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String data = "(1,2)";

        String result = data.substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("data의 범위 밖일 경우 StringIndexOutOfBoundsException 확인하는 테스트")
    void chatAt() {
        String data = "abc";

        assertThatThrownBy(() -> {
            char c = data.charAt(data.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("out of bounds for length");
    }
}
