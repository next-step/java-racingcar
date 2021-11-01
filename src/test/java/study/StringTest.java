package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("\"1,2\" split 테스트")
    void splitTest1() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\" split 테스트")
    void splitTest2() {
        String[] result = "1".split(",");
        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("\"(1,2)\"에서 substring() 메소드로 ()를 제거하는 테스트")
    void substringTest() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }
}
