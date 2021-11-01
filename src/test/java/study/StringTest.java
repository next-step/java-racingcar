package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void substring() {
        String str = "(1,2)";
        String result = str.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자 가져오기")
    void charAt() {
        String str = "abc";

        assertThat(str.charAt(0)).isEqualTo('a');

        assertThatThrownBy(() -> {
            str.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining("4");
    }

}
