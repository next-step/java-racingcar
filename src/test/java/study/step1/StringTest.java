package study.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("요구사항1, 문자열 split 확인")
    @Test
    void split() {
        String[] strContains = "1,2".split(",");
        assertThat(strContains).contains("1", "2");

        String[] strContainsExactly = "1".split(",");
        assertThat(strContainsExactly).containsExactly("1");
    }
    
    @DisplayName("요구사항2, 문자열 substring깂 확인")
    @Test
    void subString() {
        String str = "(1,2)".substring(1, 4);
        assertThat(str).isEqualTo("1,2");
    }

    @DisplayName("요구사항3, 문자열 index 확인")
    @Test
    void checkStringIndex() {
        assertThatThrownBy(() -> {
            "abc".charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}
