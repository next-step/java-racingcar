package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {

    @Test
    void split_1() {
        String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void split_2() {
        String[] actual = "1".split(",");
        assertThat(actual).contains("1");
    }
    
    @Test
    void subString() {
        String input = "(1,2)";
        String actual = input.substring(1, input.length() - 1);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드는 특정 위치의 문자를 가져온다.")
    void charAt() {
        String input = "abc";
        char actual = input.charAt(1);
        assertThat(actual).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt() 메소드는 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생한다.")
    void charAtThrownByStringIndexOutOfBoundsException() {
        String input = "abc";
        assertThatThrownBy(() -> input.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
