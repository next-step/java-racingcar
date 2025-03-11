package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void testStringSplitOne() {
        String[] result = "1".split(", ");
        assertThat(result).contains("1");
    }

    @Test
    void testStringSplitMany() {
        String[] result = "1, 2".split(", ");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void testStringSplitWithSubstring() {
        String[] result = "(1, 2)".substring(1, 5).split(", ");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void testCharAt() {
        char result = "abc".charAt(0);
        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("string 길이를 벗어난 index의 char를 가져올 때")
    void testCharAtOOB() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> "abc".charAt(3), "Index out of bound");
    }

}
