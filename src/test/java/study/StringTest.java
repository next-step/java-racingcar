package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void splitWordTest() {
        String word = "1,2";
        String[] SeparateWords = word.split(",");
        assertThat(SeparateWords[0]).isEqualTo("1");
        assertThat(SeparateWords[1]).isEqualTo("2");
    }

    @Test
    void replaceWordTest() {
        String word = "(1,2)";
        String substitutedWord = word.replaceAll("[(]", "").replaceAll("[)]", "");
        assertThat(substitutedWord).contains("1,2");
    }

    @Test
    void educeWordExceptionTest() {
        String word = "abc";
        char extractedWord = word.charAt(1);
        assertThatThrownBy(() -> {
            throw new IllegalArgumentException(String.valueOf(assertThat(extractedWord).isEqualTo('b')));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}