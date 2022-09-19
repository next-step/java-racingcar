package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        String[] data = "1,2".split(",");
        assertThat(data).containsExactly("1","2");
        data = "1".split(",");
        assertThat(data).contains("1");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String 범위를 초과한다면 IndexOutOfBoundsException를 반환한다.")
    void charAt() {
        String data = "abc";
        assertThatThrownBy(() -> {
            data.charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("%d", 5);
    }
}
