package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class StringTest {

    @Test
    void testSplit() {
        String[] result = "1,2".split(",");
        String[] result2 = "1".split(",");

        assertThat(result).containsExactly("1", "2");
        assertThat(result2).contains("1");
    }

    @Test
    void testSubstring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메소드 out of index exception 발생하는지 테스트")
    void testCharAtFail() {
        // given
        String stringValue = "abc";

        // when
        Throwable thrown = catchThrowable(() -> stringValue.charAt(stringValue.length()));

        // then
        assertThat(thrown)
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining(String.valueOf(stringValue.length()));
    }

    @Test
    @DisplayName("charAt 메소드 정상 작동 테스트")
    void testCharAtSuccess() {
        String stringValue = "abc";
        char result = stringValue.charAt(stringValue.length() - 1);
        assertThat(result).isEqualTo('c');
    }
}