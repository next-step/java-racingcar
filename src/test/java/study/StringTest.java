package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class StringTest {
    @Test
    @DisplayName("요구사항 1 contains() 테스트")
    public void split1() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("요구사항 1 containsExactly() 테스트")
    public void split2() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항 2 substring()")
    public void substring() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3  StringIndexOutOfBoundsException")
    void charAt() {
        assertThatThrownBy(() -> {
            char result = "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }
}
