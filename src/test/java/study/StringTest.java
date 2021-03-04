package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @DisplayName("문자열 1,2 함수 split 사용하여 배열 안에 있는 값을 비교한다")
    @Test
    void splitTest() {
        //GIVE
        String source = "1,2";

        //WHEN
        String[] result = source.split(",");

        //THEN
        assertThat(result).containsExactly("1","2");

        String source2 = "1";

        //WHEN
        String[] resultSecond = source2.split(",");

        //THEN
        assertThat(result).contains("1");
    }

    @DisplayName("문자열 (1,2) 함수 substring 사용하여 문자열 '(' ')'를 제거한다")
    @Test
    void subStringTest() {
        //GIVE
        String source = "(1,2)";
        //WHEN
        String result = source.substring(1,4);
        //THEN
        assertThat(result).isEqualTo("1,2");
    }
    @DisplayName("문자열 abc에 함수 charAt 사용 -> StringIndexOutOfBoundsException 발생시키기 위해+" +
            "문자열 해당 index값 보다 높은 index값을 입력하고 Exception이 발생하는지 확인한다.")
    @Test
    void charAtTest() {
        //GIVE
        String result = "abc";
        //WHEN

        //THEN
        assertThatThrownBy(() -> {result.charAt(5);}).isExactlyInstanceOf(StringIndexOutOfBoundsException.class);
        assertThat(result.charAt(2)).isEqualTo('c');
    }
}
