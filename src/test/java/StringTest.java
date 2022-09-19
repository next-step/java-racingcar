import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void testSplit1() {
        //given
        String str = "1,2";

        //when
        String[] tokens = str.split(",");

        //then
        assertThat(tokens).containsExactly("1", "2");
    }

    @Test
    void testSplit2() {
        //given
        String str = "1";

        //when
        String[] tokens = str.split(",");

        //then
        assertThat(tokens).containsExactly("1");
    }

    @Test
    void testSubstring() {
        //given
        String str = "(1,2)";

        //when
        String replaced = str.substring(1);
        replaced = replaced.substring(0, replaced.length()-1);

        //then
        assertThat(replaced).isEqualTo("1,2");
    }

    @DisplayName("문자열중 입력한 인덱스 위치의 문자가 반환된다")
    @Test
    void testCharAt1() {
        //given
        String str = "abc";

        //when
        char token = str.charAt(1);

        //then
        assertThat(token).isEqualTo('b');
    }

    @DisplayName("문자열의 길이보다 더 큰 인덱스를 입려하면 IndexOutOfBoundsException이 발생한다")
    @Test
    void testCharAt2() {
        //given
        String str = "abc";

        //when & then
        assertThatThrownBy(() -> str.charAt(4))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 4");
    }
}
