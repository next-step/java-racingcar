package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringUtilTest {

    @DisplayName("입력값을 , 로 split 했을 때")
    @Test
    void 요구사항1() {
        assertThat(StringUtil.split("1,2", ",")).contains("1", "2");
        assertThat(StringUtil.split("1", ",")).containsExactly("1");
    }

    @DisplayName("substring 으로 () 제거")
    @Test
    void 요구사항2() {
        assertThat(StringUtil.deleteBracket("(1,2)")).isEqualTo("1,2");
    }

    @DisplayName("String 의 charAt 위치 값으로 문자열 반환")
    @Test
    void 요구사항3_success() {
        assertThat(StringUtil.getChar("abc", 0)).isEqualTo('a');
        assertThat(StringUtil.getChar("abc", 1)).isEqualTo('b');
        assertThat(StringUtil.getChar("abc", 2)).isEqualTo('c');
    }

    @DisplayName("String 의 charAt 위치 값을 벗어날 때 IndexOutBoundsException 발생")
    @Test
    void 요구사항3_throw_exception() {
        assertThatThrownBy(() -> StringUtil.getChar("abc", 3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 3, Size: 3");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(-1));
    }
}