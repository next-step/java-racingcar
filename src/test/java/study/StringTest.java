package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
    }

    @Test
    void splitSingle() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void substring(){
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt()에서의 index가 배열의 범위에서 벗어났을 때, IndexOutOfBoundException 테스트")
    void charAtOutOfIndex() {
    void charAt() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }

    @Test
    void charAt() {
        assertThat("abc".charAt(0)).isEqualTo('a');
    }
}
}