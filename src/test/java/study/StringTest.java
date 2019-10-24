package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("charAt 테스트")
    void charAt() {
        assertThatThrownBy(() -> {
            "123".charAt(3);
        })
//                .isInstanceOf(IllegalStateException.class);
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("split 분리 테스트 ")
    void split() {
        String[] result = "1,2".split(",");

        assertThat(result).contains("1");
        assertThat(result).hasSize(2);
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("substring 테스트")
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }
}
