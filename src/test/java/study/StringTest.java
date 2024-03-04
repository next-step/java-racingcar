package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        String[] result1 = "1,2".split(",");
        assertThat(result1).containsExactly("1", "2");

        String[] result2 = "1".split(",");
        assertThat(result2).containsExactly("1");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt()에 대한 학습 테스트 - 인덱스 초과 시 예외 발생")
    void charAt() {
        String abc = "abc";

        char c = abc.charAt(2);
        assertThat(c).isEqualTo('c');

        assertThatThrownBy(() -> {
            abc.charAt(3);
        })
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");

    }
}
