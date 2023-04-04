package study;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TestString {

    @Test
    @DisplayName("문자열 split 테스트")
    public void test_splitTest() {
        String str = "1,2";
        String[] arr = str.split(",");

        assertThat(arr).contains("1", "2");
        assertThat(arr).doesNotContain(",");
        assertEquals(arr[0], "1");
    }

    @Test
    @DisplayName("문자열 substring 테스트")
    public void test_substringTest() {
        String str = "(1,2)";
        String result = str.substring(1, str.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }
    
    @Test
    @DisplayName("문자열 charAt & 예외 테스트")
    public void test_charAtTest() {
        String str = "abc";
        char result = str.charAt(0);

        assertThat(result).isEqualTo('a');

        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            str.charAt(str.length() + 1);
        });

        assertThatThrownBy(() -> {
            str.charAt(str.length() + 1);
        }).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("Index 4 out of bounds for length 3");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                str.charAt(str.length() + 1);
            });
    }

}
