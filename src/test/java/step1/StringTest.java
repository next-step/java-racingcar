package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    /**
     * 요구 사항 1
     */
    @Test
    void splitTestWithSeparatedString() {
        String given = "1,2";

        String[] splitResult = given.split(",");

        assertThat(splitResult).contains("1", "2");
    }

    @Test
    void splitTestWithoutSeparatedString() {
        String given = "1";

        String[] splitResult = given.split(",");

        assertThat(splitResult).containsExactly("1");
    }

    /**
     * 요구 사항 2
     */
    @Test
    void substringTest() {
        String given = "(1,2)";

        String withoutBracket = given.substring(1, 4);

        assertThat(withoutBracket).isEqualTo("1,2");
    }

    /**
     * 요구 사항 3
     */
    @Test
    @DisplayName("특정 위치 문자를 가져오는 테스트")
    void charAtTest() {
        String given = "abc";

        char chatAt0 = given.charAt(0);
        char chatAt1 = given.charAt(1);
        char chatAt2 = given.charAt(2);

        assertThat(chatAt0).isEqualTo('a');
        assertThat(chatAt1).isEqualTo('b');
        assertThat(chatAt2).isEqualTo('c');
    }


    @Test
    @DisplayName("특정 위치 문자를 가져올 때 위치 값을 벗어날 경우, StringIndexOutOfBoundsException 발생")
    void charAtExceptionTest() {
        assertThatThrownBy(() -> {
            String given = "abc";
            char chatAt0 = given.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("out of range: 3");
    }
}
