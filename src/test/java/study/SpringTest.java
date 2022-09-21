package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SpringTest  {

    @DisplayName("1과 2 split 하기")
    @Test
    void splitWithOneAndTwo() {
        //given & when
        String data = "1,2";
        String[] split = data.split(",");

        //then
        assertThat(split).contains("1", "2");
    }

    @DisplayName("1 split 하기")
    @Test
    void splitWithOne() {
        //given & when
        String data = "1";
        String[] split = data.split(",");

        //then
        assertThat(split).containsExactly("1");
    }

    @DisplayName("(1,2) 에서 괄호 없애기")
    @Test
    void substring() {
        //given & when
        String data = "(1,2)";
        String result = data.substring(1,4);

        //then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자를 가져올 때, 위치값을 벗어나면 IndexOutOfBoundsException 이 발생한다.")
    void chatAt() {
        //given & when
        String data = "abc";

        //then
        assertThatThrownBy(() -> {
            data.charAt(100);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
