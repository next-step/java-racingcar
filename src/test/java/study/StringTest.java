package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @DisplayName("요구사항1")
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("요구사항2")
    @Test
    void testSubString() {
        String reqString = "(1,2)";
        String result = reqString.substring(reqString.indexOf("(")+1, reqString.indexOf(")"));
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("요구사항3")
    @Test
    void testCharAt() {
        String reqString = "abc";
        int reqIndex = 5;
        String message = "Index: "+reqIndex+", Size: "+reqString.length();
        assertThat(reqString.charAt(0)).isEqualTo('a');

        assertThatThrownBy(() -> {
            reqString.charAt(reqIndex);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
