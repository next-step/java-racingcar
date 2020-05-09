package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void 요구사항1_split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void 요구사항2_split() {
        String data = "(1,2)";
        String result = data.substring(1, data.length() - 1);
        assertThat("1,2").isEqualTo(result);
    }

    @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트")
    @Test
    void 요구사항3_split() {
        String data = "abc";

        assertThatThrownBy(() -> {
            data.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

    }
}
