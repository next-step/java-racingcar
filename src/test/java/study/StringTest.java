package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {
    @Test
    void request1_split1() {
        final String data = "1,2";

        final String[] result = data.split(",");

        assertThat(result).hasSize(2)
                .containsExactly("1", "2");
    }

    @Test
    void request1_split2() {
        final String data = "1";

        final String[] result = data.split(",");

        assertThat(result).hasSize(1)
                .contains("1")
                .doesNotContain("2");
    }

    @Test
    void request2_substring1() {
        final String data = "(1,2)";

        final String result = data.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메서드를 통해 특정 위치의 문자를 가져오는 테스트를 수행하며, 범위를 벗어나면 예외가 발생한다")
    void request3_charAt1() {
        final String data = "abc";

        assertThat(data.charAt(0)).isEqualTo('a');
        assertThat(data.charAt(1)).isEqualTo('b');
        assertThat(data.charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> data.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
