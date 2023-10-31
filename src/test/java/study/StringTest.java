package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @DisplayName("split 테스트")
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("substring 테스트")
    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt 테스트")
    @Nested
    class charAtTest {
        String data = "abc";

        @DisplayName("성공")
        @Test
        void success() {
            char result = data.charAt(0);
            assertThat(result).isEqualTo('a');
        }

        @DisplayName("실패")
        @Test
        void fail() {
            assertThatExceptionOfType(IndexOutOfBoundsException.class)
                    .isThrownBy(() -> {
                        data.charAt(4);
                    })
                    .withMessage("String index out of range: 4")
                    .withMessageContaining("out of range")
                    .withNoCause();
        }
    }

}
