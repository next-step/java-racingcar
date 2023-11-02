package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split_구분자_여러개() {
        String[] result = "1,2:3".split(",|\\:");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt(성공) - String의 index내로 CharAt으로 특정위치의 문자를 가져온다")
    void charAtSuccess() {
        char result = "abc".charAt(0);
        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt(실패) - String의 index범위밖으로 CharAt을 사용하면 StringIndexOutOfBoundsException이 발생한다")
    void charAtFail() {
        assertThatThrownBy(() -> "abc".charAt(10))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 10");
    }
}
