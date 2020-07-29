package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    public void split() {
        String[] values = "1,2".split(",");
        assertThat(values).contains("1", "2");
        String[] singleValue = "1".split(",");
        assertThat(singleValue).containsExactly("1");
    }

    @Test
    public void substring() {
        String value = "(1,2)";
        assertThat(value.substring(1, value.length() - 1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메서드 StringIndexOutOfBoundsException 테스트")
    public void charAt() {
        assertThatThrownBy(() -> "abc".charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
