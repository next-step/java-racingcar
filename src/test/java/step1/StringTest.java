package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @DisplayName("주어진 문자열을 split()메서드와 패턴 ','를 이용해 분리한다.")
    @Test
    void splitTest() {
        // given
        String string = "1,2";

        // when
        String[] split = string.split(",");

        // then
        assertThat(split).hasSize(2)
            .contains("1", "2");
    }

    @DisplayName("주어진 문자열을 split()메서드와 패턴 ','을 이용해 분리할 때 배열이 반환되는지 확인한다.")
    @Test
    void isContainArrayAfterSplit() {
        // given
        String string = "1";

        // when
        String[] split = string.split(",");

        // then
        assertThat(split).hasSize(1)
            .containsExactly("1");
    }

    @DisplayName("주어진 문자열을 substring()을 이용해 괄호를 제거 한다.")
    @Test
    void substringTest() {
        // given
        String string = "(1,2)";

        // when
        String substring = string.substring(1, 4);

        // then
        assertThat(substring).isEqualTo("1,2");
    }

    @DisplayName("주어진 문자열을 charAt()을 이용해 특정 위치의 문자를 반환한다.")
    @Test
    void charAtTest() {
        // given
        String string = "abc";

        // when
        char first = string.charAt(0);
        char second = string.charAt(1);
        char third = string.charAt(2);

        // then
        assertThat(first).isEqualTo('a');
        assertThat(second).isEqualTo('b');
        assertThat(third).isEqualTo('c');
    }

    @DisplayName("chatAt()을 이용해 특정 위치의 문자를 구할 때 인덱스 범위를 초과하는 값을 입력해 예외를 발생시킨다.")
    @Test
    void charAtToThrowException() {
        // given
        String string = "abc";

        // when & then
        assertThatThrownBy(() -> string.charAt(4)).isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessage("String index out of range: 4");
    }
}
