package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("1개 이상의 구분자를 가진 String을 split 할 때")
    void splitTest() throws Exception {
        // given
        String data = "1,2";

        // when
        String[] result = data.split(",");

        // then
        assertThat(result).contains("1", "2");
    }

    @Test
    @DisplayName("0개 구분자를 가진 String을 split 할 때")
    void splitTest2() throws Exception {
        // given
        String data = "1";

        // when
        String[] result = data.split(",");

        // then
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("substring 이용해 특정 range의 값만 추출")
    void substringTest() throws Exception {
        // given
        String data = "(1,2)";

        // when
        String result = data.substring(1, data.length() - 1);

        // then
        assertThat(result).isEqualTo("1,2");
    }
}
