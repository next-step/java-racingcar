package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("data: \"1,2\"가 주어졌을 때, ','를 기준으로 분리시킨다.")
    void split1() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("data: \"(1,2)\"가 주어졌을 때, 양 끝을 잘라낸다.")
    void split2() {
        String data = "(1,2)";
        String result = data.substring(1, data.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("data: \"abc\"가 주어졌을 때, 특정 위치 문자를 가져온다.")
    void split3() {

        String data = "abc";
        char c = data.charAt(1);

        assertThat(c).isEqualTo('b');
        assertThatThrownBy(() -> {
            data.charAt(data.length() + 1);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("data: \"abc\"가 주어졌을 때, 위치값을 벗어나면 IndexOutOfBoundsException을 발생시킨다.")
    void split4() {

        String data = "abc";
        char c = data.charAt(1);

        assertThat(c).isEqualTo('b');
        assertThatThrownBy(() -> {
            data.charAt(data.length() + 1);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
