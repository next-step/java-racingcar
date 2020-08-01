package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

    @DisplayName("요구사항1-1 - split 테스트")
    @Test
    void split1() {
        String[] values = "1,2".split(",");
        assertThat(values).contains("1");
        assertThat(values).contains("2");
        assertThat(values).contains("1", "2");
        assertThat(values).contains("2", "1");
        assertThat(values).containsExactly("1", "2");
    }

    @DisplayName("요구사항1-2 - split 테스트")
    @Test
    void split2() {
        String[] values = "1".split(",");
        assertThat(values).contains("1");
        assertThat(values).containsExactly("1");
    }

    @DisplayName("요구사항2 - substring 테스트")
    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).contains("1, 2");
    }

    @DisplayName("요구사항3 - charAt 테스트")
    @Test
    void charAt() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
          .hasMessageContaining("String index out of range: 3");
    }

}
