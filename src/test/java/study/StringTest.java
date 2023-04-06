package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("String 의 split 은 regex 값으로 분리된다.")
    void split01() {
        String data = "1,2";

        String[] sut = data.split(",");

        assertThat(sut).containsExactly("1", "2");
    }

    @Test
    @DisplayName("String 의 split 은 regex 에 해당하는 값이 없으면 자신을 반환한다.")
    void split02() {
        String data = "1";

        String[] sut = data.split(",");

        assertThat(sut).containsExactly(data);
    }

    @Test
    @DisplayName("String 의 substring 은 해당 위치의 값을 가져온다.")
    void substringTest01() {
        String data = "(1,2)";

        String sut = data.substring(1, 4);

        assertThat(sut).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String 의 charAt 은 특정 위치의 문자를 가져온다.")
    void charAtTest01() {
        String data = "abc";

        assertThat(data.charAt(0)).isEqualTo('a');
        assertThat(data.charAt(1)).isEqualTo('b');
        assertThat(data.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("String 의 charAt 은 위치 값을 벗어나면 StringIndexOutOfBoundsException 이 발생한다.")
    void charAtTest02() {
        String data = "abc";

        assertThatThrownBy(() -> data.charAt(data.length() + 1)).isInstanceOf(StringIndexOutOfBoundsException.class)
                                                                .hasMessageContaining("String index out of range:");
    }
}
