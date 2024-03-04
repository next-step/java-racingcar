package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("1. split() 메소드 테스트")
    void multipleSplitTest() {
        String input = "1,2";
        String[] output = input.split(",");
        assertThat(output).contains("1","2");
    }

    @Test
    @DisplayName("1. split() 메소드 테스트 - 단일 문자")
    void singleSplitTest() {
        String input = "1";
        String[] output = input.split(",");
        assertThat(output).containsExactly("1");
    }

    @Test
    @DisplayName("2. substring() 메소드 테스트")
    void substringTest() {
        String input = "(1,2)";
        String output = input.substring(1, 4);
        assertThat(output).isEqualTo("1,2");
    }

    @Test
    @DisplayName("3. charAt() 메소드 테스트")
    void charAtTest() {
        String input = "abc";
        char outputA = input.charAt(0);
        assertThat(outputA).isEqualTo('a');

        char outputB = input.charAt(1);
        assertThat(outputB).isEqualTo('b');

        char outputC = input.charAt(2);
        assertThat(outputC).isEqualTo('c');

        assertThatThrownBy(() -> {
            input.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
