package step1;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void splitContainsExactly() {
        String[] test1 = "1,2".split(",");
        assertThat(test1).containsExactly("1", "2");
    }

    @Test
    void splitContains() {
        String[] test1 = "1".split(",");
        assertThat(test1).contains("1");
    }


    @Test
    void subString() {
        String test1 = "(1,2)".substring(0, 4);
        assertThat(test1).contains("1,2");
    }

    @Test
    void chatAt() {
        char test1 = "abc".charAt(1);
        assertThat(test1).isEqualTo('b');
    }

    @Test
    @DisplayName("String Index Exception Test")
    void indexOutTest() {
        String testStr = "abc";
        int length = testStr.length();
        assertThatThrownBy(() -> {
            char test1 = testStr.charAt(length);
        }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 3");
    }
}
