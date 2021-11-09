package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    public void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    public void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 특정 위치의 문자를 가져온다")
    public void charAt() {
        String result = "abc";
        assertThatThrownBy(() ->
                result.charAt(3)
        ).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
