package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("1,2를 ,로 split 했을 때 반환 되는 배열 값에 대한 검증")
    public void splitTest(){
        // given
        String candidateStr = "1,2";

        // when
        String [] result = candidateStr.split(",");

        // then
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열의 맨앞과, 맨뒤에 있는 괄호가 잘 제거 되었는지 검증")
    public void substringTest(){
        // given
        String candidateStr = "(1,2)";

        // when
        String extractLeft = candidateStr.substring(candidateStr.indexOf("(") + 1);
        String extractRight = extractLeft.substring(0, extractLeft.indexOf(")"));

        // then
        assertThat(extractRight).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자 열에서 특정 문자의 위치를 통해 문자 값을 가져옴")
    public void charAtTest(){
        // given
        String candidateStr = "abc";

        // when
        char a = candidateStr.charAt(0);
        char b = candidateStr.charAt(1);
        char c = candidateStr.charAt(2);

        // then
        assertThat(a).isEqualTo('a');
        assertThat(b).isEqualTo('b');
        assertThat(c).isEqualTo('c');
    }

    @Test
    @DisplayName("문자열을 벗어나는 문자의 위치를 입력했을 때 Exception이 발생")
    public void charAtExpectExceptionTest(){

        // given
        String candidateStr = "abc";

        assertThatThrownBy(()->{
            // when
            char empty = candidateStr.charAt(10);
            // then
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 10");

        // when & then
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> candidateStr.charAt(candidateStr.length()));
    }
}
