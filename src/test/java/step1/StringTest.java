package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("String Split Test")
    void split() {
        String inputStr = "1,2";

        String[] result = inputStr.split(",");

        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1만 Split 했을때 테스트")
    void split2() {

        String inputStr = "1";

        String[] split = inputStr.split(",");

        assertThat(split).containsExactly("1");

    }

    @Test
    @DisplayName("괄호 삭제 테스트")
    void removeBraketTest() {

        String inputStr = "(1,2)";

        String result = inputStr.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 으로 각자리의 문자를 잘 가져오는지 테스")
    void getChar() {

        String input = "abc";

        char result = input.charAt(0);

        assertThat(result)
                .isEqualTo('a');

        char result1 = input.charAt(1);

        assertThat(result1)
                .isEqualTo('b');

        char result2 = input.charAt(2);

        assertThat(result2)
                .isEqualTo('c');
    }

    @Test
    @DisplayName("index 범위를 벗어낫을때 Exception Test")
    void checkException() {

        String input = "abc";

        assertThatThrownBy(() -> {
            input.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("out of range: 4");
    }
}
