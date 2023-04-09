package study.carrace.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {
    @Test
    @DisplayName("요구사항 1 - \"1,2\"를 `,`로 split 했을 때 배열 반환")
    void split1() {
        // given
        String str = "1,2";

        // when
        String[] split = str.split(",");

        // then
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항 1 - \"1\"을 `,`로 split 했을 때 배열 반환")
    void split2() {
        // given
        String str = "1";

        // when
        String[] split = str.split(",");

        // then
        assertThat(split).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2 - \"(1,2)\" 값이 주어졌을 때, `()`을 제거하여 문자열 반환")
    void substring() {
        // given
        String str = "(1,2)";
        
        // when
        String substring = str.substring(1, 4);

        // then
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3 - \"abc\" 값이 주어졌을 때, 특정 위치의 문자를 반환." +
                 "위치 값을 넘을 경우 StringIndexOutOfBoundsException 예외 발생")
    void charAt() {
        // given
        String str = "abc";

        // when, then
        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> str.charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 3");
    }
}
