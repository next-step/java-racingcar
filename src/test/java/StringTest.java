import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 및 Exception 발생 학습테스트")
    void charAt() {
        assertThatThrownBy(() -> {
            char result = "abc".charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 4");
    }
}
