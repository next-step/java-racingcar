package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] arr = "1,2".split(",");
        assertThat(arr).contains("1");
        assertThat(arr).containsExactly("1", "2");

        String[] arr2 = "1".split(",");
        assertThat(arr2).containsOnly("1");
    }

    @Test
    void subString() {
        String str = "(1,2)";
        String subString = str.substring(1, 4);
        assertThat(subString).isEqualTo("1,2");
    }

    @DisplayName("특정 위치의 문자를 가져온다")
    @Test
    void charAt() {
        String str = "abc";
        assertThat(str.charAt(0)).isEqualTo('a');

        assertThatThrownBy(() -> str.charAt(str.length()))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}
