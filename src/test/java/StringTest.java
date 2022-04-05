import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @DisplayName("\"1,2\"을 ,로 split 했을 떄 1과 2로 분리")
    @Test
    void split_multiple() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환")
    @Test
    void split_single() {
        assertThat("1".split(",")).containsExactly("1");
    }

    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환")
    @Test
    void substring() {
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt()로 특정 위치의 문자를 가져온다.")
    @Test
    void charAt() {
        assertAll(
                () -> assertThat("abc".charAt(0)).isEqualTo('a'),
                () -> assertThat("abc".charAt(1)).isEqualTo('b'),
                () -> assertThat("abc".charAt(2)).isEqualTo('c')
        );
    }

    @DisplayName("charAt() 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생")
    @Test
    void charAt_exception() {
        assertThatThrownBy(() -> "abc".charAt(5)).isInstanceOf(StringIndexOutOfBoundsException.class)
                                                 .hasMessage("String index out of range: 5");
    }
}
