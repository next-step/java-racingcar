package study.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {
    @Test
    @DisplayName("split()을 이용하여 문자열 자르기")
    void split_test() {
        String data = "1,2";
        String expected = "1";
        String[] actual = data.split(",");
        assertThat(actual).contains(expected);
    }

    @Test
    @DisplayName("substring()을 이용하여 첫 번째와 마지막 문자 자르기")
    void substring_test() {
        String data = "(1,2)";
        String expected = "1,2";
        String actual = data.substring(1, data.length() - 1);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("charAt()을 이용하여 특정 위치의 문자 가져오기")
    void charAt_test() {
        String data = "abc";
        char expected = 'b';
        char result = data.charAt(1);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("charAt()을 이용하여 특정 위치의 문자를 가져올 때, 인덱스를 벗어나는 경우 StringIndexOutOfBoundsException 발생")
    void charAt_test_exception() {
        String data = "abc";
        assertThrows(StringIndexOutOfBoundsException.class, () -> data.charAt(data.length()));
    }
}
