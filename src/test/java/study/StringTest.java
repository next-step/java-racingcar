package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        // given
        String str = "1,2";
        // when
        String[] result = str.split(",");
        // then
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        // given
        String str = "(1,2)";
        // when
        String result = str.substring(1, 4);
        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메서드르 통해 특정 위치의 문자를 가져온다.")
    void charAt_O() {
        // given
        String str = "abc";
        // when
        char result = str.charAt(2);
        // then
        assertThat(result).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt 메서드르 통해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생한다.")
    void charAt_X() {
        // given
        String str = "abc";
        // when, then

        assertThatThrownBy(() -> {
            str.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
