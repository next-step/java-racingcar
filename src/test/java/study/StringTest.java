package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    @DisplayName("String 클래스의 split 테스트")
    void split() {
        String[] data = "1,2".split(",");
        assertThat(data).containsExactly("1", "2");
        
        data = "1".split(",");
        assertThat(data).contains("1");
    }


    @Test
    @DisplayName("String 클래스의 substring 테스트")
    void substring() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String 클래스의 charAt 테스트")
    void charAt() {
        String input = "abc";
        char charAt = input.charAt(0);
        assertThat(charAt).isEqualTo('a');

        char charAt2 = input.charAt(1);
        assertThat(charAt2).isEqualTo('b');

        char charAt3 = input.charAt(2);
        assertThat(charAt3).isEqualTo('c');

    }

    @Test
    @DisplayName("String 클래스의 charAt 테스트")
    void exception_test_charAt() {
        String input = "abc";

        assertThatThrownBy(() -> {
            char charAt4 = input.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: 3");
    }


}
