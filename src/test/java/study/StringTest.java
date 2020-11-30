package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void containsSplitString() {
        String str = "1,2";
        String[] splitStr = str.split(",");

        assertThat(splitStr).contains("1","2");

        String str2 = "1";
        String[] splitStr2 = str2.split(",");

        assertThat(splitStr2).containsExactly("1");
    }

    @Test
    void returnSubstring() {
        String str = "(1,2)";
        String substringStr = str.substring(1,4);

        assertThat(substringStr).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc 값이 주어졌을 때 charAt() 메소드를 활용해 특정 위치의 문자 가져오기")
    void returnCharAt() {
        String str = "abc";
        char cutStr = str.charAt(2);

        assertThat(cutStr).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생")
    void charAtIndexOutOfBoundsException() {
        String str = "abc";

        assertThatThrownBy(() -> {
            str.charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 2, Size: 2");
    }
}
