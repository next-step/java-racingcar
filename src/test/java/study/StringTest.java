package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void Split() {
        String[] values1 = "1,2".split(",");
        assertThat(values1).containsExactly("1", "2"); // non-order validation

        String[] values2 = "1".split(",");
        assertThat(values2).containsExactly("1"); // order validation
    }

    @Test
    void Substring() {
        String values = "(1,2)".substring(1,4);
        assertThat(values).contains("1,2");
    }

    @Test
    @DisplayName("String index out of Bounds Test")
    void CharAt() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class); // exception이 반환이 돼야 pass

    }
}
