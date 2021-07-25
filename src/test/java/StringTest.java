import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("문자열 분리 테스트 01")
    public void split01() {
        //given
        String given = "1,2";
        //when
        String[] split = given.split(",");
        //then
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열 분리 테스트 02")
    public void split02() {
        //given
        String given = "1";
        //when
        String[] split = given.split(",");
        //then
        assertThat(split).contains("1");
    }

    @Test
    @DisplayName("문자열 자르기 테스트")
    public void substring() {
        //given
        String given = "(1,2)";
        //when
        String substring = given.substring(1, 4);

        //then
        assertThat(substring).isEqualTo("1,2");

    }

    @Test
    @DisplayName("문자열 꺼내기 테스트")
    public void charAt01() {
        //given
        String given = "abc";

        //then
        assertThat(given.charAt(0)).isEqualTo('a');
        assertThat(given.charAt(1)).isEqualTo('b');
        assertThat(given.charAt(2)).isEqualTo('c');

    }

    @Test
    @DisplayName("문자열 범위 밖 꺼낼 시 Exception 테스트")
    public void charAt02() {
        //given
        String given = "abc";

        assertThatThrownBy(() -> given.charAt(3))
                .isExactlyInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
