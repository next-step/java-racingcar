package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringClassTest {
    @Test
    @DisplayName("문자열 1,2를 ,로 split 했을 때 1과 2로 잘 분리하여 배열로 반환")
    void splitDoubleString() {
        //given
        String data = "1,2";

        //when
        String[] result = data.split(",");

        //then
        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("문자열 1을 ,로 split 했을 때 1 만을 포함하는 배열 반환")
    void splitSingleString(){
        //given
        String data = "1";

        //when
        String[] result = data.split(",");

        //then
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("문자열 (1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2를 반환")
    void substringParentheses() {
        //given
        String data = "(1,2)";
        //when
        String result = data.substring(1,data.length()-1);
        //then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열 abc 값이 주어졌을 때 String의 charAt() 메소드를 활용해 index 1의 문자인 b를 반환")
    void charAtString() {
        //given
        String data = "abc";
        //when
        char result = data.charAt(1);
        //then
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생")
    void charAtIndexOutOfBounds() {
        //given
        String data = "abc";
        //when//then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> data.charAt(4) ).withMessageMatching("String index out of range: \\d+");
    }
}
