package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("1,2를 ,로 split 하여 잘 분리되는지 테스트")
    void 요구사항1_1() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1을 ,로 split 했을때 1만을 포함하는 배열이 반환되는지 테스트")
    void 요구사항1_2() {
        String[] result2 = "1".split(",");
        assertThat(result2).contains("1");
    }

    @Test
    @DisplayName("(1,2) 주어졌을때, substring() 활용하여 1,2로 반환되는지 테스트")
    void 요구사항2() {
        String data = "(1,2)";
        String result = data.substring(0, data.length());
        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("abc 값이 주어졌을때, charAt() 활용하여 특정 위치 문자 가져오는 테스트")
    void 요구사항3_1() {
        String data = "abc";
        char result = data.charAt(0);
        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException 발생하는 테스트")
    void 요구사항3_2() {
        String data = "abc";
        assertThatThrownBy(() -> {
            char result = data.charAt(4);
            assertThat(result).isEqualTo('a');
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
