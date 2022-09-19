package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void split() {
        String given = "1,2";
        String[] result = given.split(",");

        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String given = "(1,2)";
        String result = given.substring(1, 4);

        System.out.println(result);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt 테스트")
    @Test
    void charAt() {
        String given = "abc";
        char result = given.charAt(0);

        assertThat(result).isEqualTo('a');
    }


    @DisplayName("charAt 테스트 범위 초과 시 예외발생")
    @Test
    void charAt_exception() {
        String given = "abc";

        assertThatThrownBy(() -> {
            given.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
