import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @DisplayName("1,2를 ','로 split 했을 때 1과 2로 잘 분리되는지 확인한다.")
    @Test
    void splitTest() {
        // given
        String str = "1,2";

        // when
        String[] sut = str.split(",");

        // then
        assertAll(() -> assertThat(sut).contains("1", "2"), () -> assertThat(sut).containsExactly("1", "2"));
    }

    @DisplayName("(1,2) 값이 주어졌을 때 substring 활용해 괄호를 제거 한다.")
    @Test
    void substringTest() {
        // given
        String str = "(1,2)";

        // when
        String sut = str.substring(1, str.length() - 1);

        // then
        assertThat(sut).isEqualTo("1,2");
    }

    @DisplayName("abc 값이 주어졌을 때 charAt 활용해 특정 위치의 문자를 가져온다.")
    @Test
    void charAtTest() {
        // given
        String str = "abc";

        // when
        char sut = str.charAt(1);

        // then
        assertThat(sut).isEqualTo('b');
    }

    @DisplayName("charAt 활용 시 위치 값을 벗어나면 에러가 발생한다.")
    @Test
    void charAtExceptionTest() {
        // given
        String str = "abc";

        // when
        // then
        assertThatThrownBy(() -> {
            str.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
