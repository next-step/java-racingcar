package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("split 메소드 학습 테스트")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("substring 메소드 학습 테스트")
    void substring() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메소드를 활용한 StringIndexOutOfBoundsException 발생 테스트")
    void charAt() {
        String data = "abc";
        assertThat(data.charAt(0)).isEqualTo('a');
        assertThatThrownBy(() -> {
            data.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
          .hasMessageContaining("range: 3");
    }
}
