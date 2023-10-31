package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("1,2와 같이 콤마로 구분되어 있는 문자열을 콤마 구분기호로 split()하면 문자열 배열로 반환된다.")
    void splitTest1() {
        // given
        final String givenData = "1,2";

        // when
        final String[] result = givenData.split(",");

        // then
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1과 같이 구분기호를 포함하지 않은 문자열을 구분기호로 split()해도 문자열 배열로 반환된다.")
    void splitTest2() {
        // given
        final String givenData = "1";

        // when
        final String[] result = givenData.split(",");

        // then
        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("subString()으로 start index부터 end index까지 추출한다.")
    void subStringTest() {
        // given
        final String givenData = "(1,2)";

        // when
        final String result = givenData.substring(1, 4);

        // then
        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("chatAt 메소드의 인자로 문자열을 벗어난 인덱스를 입력하면 StringIndexOutOfBoundsException 예외가 발생한다.")
    void chatAtTest() {
        // given
        final String givenData = "abc";

        // when
        // then
        assertThatThrownBy(() -> {
            givenData.charAt(9);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 9");
    }

}
