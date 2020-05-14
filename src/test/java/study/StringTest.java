package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void splitThenArray() {
        String given = "1,2";
        String[] actual = given.split(",");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void splitThenSingleSizeArray() {
        String given = "1";
        String[] actual = given.split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void subString() {
        String given = "(1,2)";
        String actual = given.substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열의 범위가 벗어난 위치의 문자를 가져오면 예외가 발생한다.")
    void charAtIfOutOfBoundsThrowException() {
        assertThatThrownBy(() -> { "abc".charAt(4);})
            .isInstanceOf(IndexOutOfBoundsException.class);
    }

}
