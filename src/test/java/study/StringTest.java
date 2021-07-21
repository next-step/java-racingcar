package study;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("split을 사용했을 때 문자열이 분리되어야 한다.")
    void splitTest() {

        //when
        String input = "1,2";

        //given
        String[] result = input.split(",");

        //then
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("substring을 사용했을 때 특정 구간의 문자열이 반환되어야 한다.")
    void substringTest() {

        //when
        String input = "(1,2)";

        //given
        String result = input.substring(1,4);

        //then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt을 사용했을 때 특정 위치의 Character가 반환되어야 한다.")
    void charAtTest() {

        //when
        String input = "abc";

        //given
        char result = input.charAt(0);

        //then
        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt을 사용했을 때 input 범위를 벗어나면 Exception이 발생해야 한다.")
    void charAtExceptionTest() {

        //when
        String input = "abc";
        int index = 5;

        //given & then
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(index))
                .withMessageMatching("String index out of range: " + index);
    }

}
