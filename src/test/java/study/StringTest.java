package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("[요구사항 1] split() 학습 테스트")
    void splitTest() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1", "2");

        result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("[요구사항 2] substring() 학습 테스트")
    void substringTest() {
        String resultStr = "(1,2)";
        String[] result = resultStr.substring(1, resultStr.length() - 1).split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("[요구사항 3] String객체에서 charAt메소드를 사용하였을때 생길 수 있는 String index out of range 에 대한 학습 테스트")
    void charAtTest() {
        String result = "abc";
        assertThatThrownBy(() -> {
            result.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: 4");
    }
}
