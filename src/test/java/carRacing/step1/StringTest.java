package carRacing.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("split 메서드 학습 테스트")
    void split() {
        String[] strings = "1,2".split(",");
        assertThat(strings).contains("1", "2");

        String[] strings2 = "1".split(",");
        assertThat(strings2).containsExactly("1");
    }

    @Test
    @DisplayName("substring 메서드 학습 테스트")
    void substring() {
        String substringResult = "(1,2)".substring(1, 4);
        assertThat(substringResult).contains("1,2");
    }

    @Test
    @DisplayName("charAt 메서드 학습 테스트")
    void charAt() {
        char c = "abc".charAt(0);
        assertThat(c).isEqualTo('a');
        assertThatThrownBy(() -> {
            "abc".charAt(10);
        }).isInstanceOf(IndexOutOfBoundsException.class)
          .hasMessageContaining("String index out of range: 10");
    }
}
