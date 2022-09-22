package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {


    @Test
    @DisplayName("split containsExactly")
    void split() {
        String testData = "1,2";
        final String[] result = testData.split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("split containsExactly one")
    void split2() {
        String testData = "1";
        final String[] result = testData.split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("charAt() out of bounds exception test")
    void chatAt() {
        String testData = "abc";
        assertThat(testData.charAt(0)).isEqualTo('a');
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                testData.charAt(4);
            }).withMessageContaining("index");
    }
}
