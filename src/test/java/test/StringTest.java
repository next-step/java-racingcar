package test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    void 문자열_분할_테스트() {
        // given
        final String str = "1,2";

        // when
        final String[] split = str.split(",");

        // then
        assertThat(split).containsExactly("1", "2");
    }
    
    @Test
    void 문자열_자르기_테스트() {
        // given
        final String str = "(1,2)";
        
        // when
        final String substring = str.substring(1, str.length() - 1);
        
        // then
        assertThat(substring).isEqualTo("1,2");
    }
    
    @Test
    void 문자열에서_특정_위치의_문자_가져오기_테스트() {
        // given
        final String str = "abc";
        
        // when
        final char charAt = str.charAt(1);
        
        // then
        assertThat(charAt).isEqualTo('b');
    }
    
    @Test
    void 문자열에서_위치_값이_벗어나면_예외_발생() {
        // given
        final String str = "abc";
        
        // when
        
        // then
        assertThatThrownBy(() -> str.charAt(3))
            .isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: 3");
    }
}
