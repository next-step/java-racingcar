package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("요구사항 1-1 : 1과 2로 잘 분리되는지 확인")
    void split() {
        String[] result= "1,2".split(",");
        assertThat(result).contains("1","2");
    }

    @Test
    @DisplayName("요구사항 1-2 : 1만을 포함하는 배열이 반환되는지 확인")
    void splitExactly() {
        String[] result= "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2 :  () 제거 후 문자열 확인")
    void splitRoundBrackets() {
        String result = "(1,2)";
        result = result.substring(1,result.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3-1 : charAt()을 활용한 특정 위치 문자를 가져오는지 확인")
    void charAt() {
        char result = "abc".charAt(0);
        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("요구사항 3-2 : 문자의 위치값을 벗어나면 익센셥이 발생하는지 확인")
    void charAtWithException() {
        assertThatThrownBy(() -> { "abc".charAt(5); })
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("요구사항 3-3 : 문자의 위치값을 벗어나면 익센셥이 발생하는지 확인")
    void charAtWithExceptionOfType() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> { "abc".charAt(5); });
    }

}
