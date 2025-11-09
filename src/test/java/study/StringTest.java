package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void 문자열_분리_테스트() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    void 괄호_제거_테스트() {
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자 위치 확인 테스트")
    void charAtTest() {
        String str = "abc";
        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("문자열 인덱스 범위 밖 조회 시 예외 테스트")
    void charAtExceptionTest() {
        String str = "abc";
        assertThatThrownBy(() -> str.charAt(-1))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
        assertThatThrownBy(() -> str.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
