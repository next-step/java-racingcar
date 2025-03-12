import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    /**
     * Request 1 : "1,2"를 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 테스트
     */
    @Test
    void splitWithSeperatorTest() {
        String[] result = "1,2".split(",");
        Assertions.assertAll(
            () -> assertThat(result).contains("1"),
            () -> assertThat(result).contains("2"),
            () -> assertThat(result).containsExactly("1", "2")
        );
    }

    @Test
    void splitWithoutSeperatorTest() {
        String[] result = "1".split(",");
        Assertions.assertAll(
            () -> assertThat(result).containsExactly("1"),
            () -> assertThat(result).doesNotContain("2")
        );
    }

    /**
     * Request 2 : "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 괄호를 제거하고 "1,2"를 반환하는 테스트
     */
    @Test
    void extractParenthesisTest() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    /**
     * Request 3 : "abc" 문자열을 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 테스트
     */
    @Test
    @DisplayName("abc 문자열의 특정 위치 문자 가져오기")
    void charAtTest()  {
        String data = "abc";
        Assertions.assertAll(
            () -> assertThat(data.charAt(0)).isEqualTo('a'),
            () -> assertThat(data.charAt(1)).isEqualTo('b'),
            () -> assertThat(data.charAt(2)).isEqualTo('c'),
            () -> assertThatThrownBy(() -> {
                data.charAt(3);
            }).isInstanceOf(StringIndexOutOfBoundsException.class)
        );
    }
}
