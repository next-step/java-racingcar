import static org.assertj.core.api.Assertions.assertThat;

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
}
