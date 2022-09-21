package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SpringTest  {

    @Test
    void splitWithOneAndTwo() {
        //given & when
        String data = "1,2";
        String[] split = data.split(",");

        //then
        assertThat(split).contains("1", "2");
    }

    @Test
    void splitWithOne() {
        //given & when
        String data = "1";
        String[] split = data.split(",");

        //then
        assertThat(split).containsExactly("1");
    }

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
