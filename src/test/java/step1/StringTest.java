package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void split1() {
        // given
        String string = "1,2";
        // when
        String[] result = string.split(",");
        // then
        assertThat(result).contains("1"); // 포함하면 됨
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1", "2"); // 순서까지 일치해야 함
    }

    @Test
    void split2() {
        // given
        String string = "1";
        // when
        String[] result = string.split(",");
        // then
        assertThat(result).contains("1");
    }

    @Test
    void substring() {
        // given
        String string = "(1,2)";
        // when
        String result = string.substring(1,4);
        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치 문자를 가져올때 위치값을 벗어나면 StringIndexOutOfBoundsException 발생")
    void charAt() {
        // given
        String string = "abc";
        // when, then
        assertThatThrownBy(() -> {
            string.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
