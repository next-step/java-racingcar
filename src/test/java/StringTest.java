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
}
