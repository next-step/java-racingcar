package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class StringTest {

    @Test
    @DisplayName("String Split Test")
    void split_1() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("String SubString Test")
    void split_2() {
        String testString ="(1,2)";
        String result = testString.substring(1).substring(0,3);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String CharAt Test")
    void charAt_1() {
        String testString = "abc";
        assertThatThrownBy(() -> {
            testString.charAt(1);
            testString.charAt(2);
            testString.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageMatching("String index out of range: 3");

    }
}
