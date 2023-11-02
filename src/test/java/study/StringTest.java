package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void requirement1_split_test1() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void requirement1_split_test2() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");

    }

    @Test
    void requirement2_substring_test() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("특정 위치의 문자를 가져오는 charAt() test")
    @Test
    void requirement3_charAt_test1() {
        String input = "abc";
        assertThat(input.charAt(1)).isEqualTo('b');
    }

    @DisplayName("chartAt() 사용시 IndexOutOfBoundsException 발생하는 경우 test")
    @Test
    void requirement3_charAt_test2() {
        String input = "abc";
        assertThatThrownBy(() -> {
            input.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}
