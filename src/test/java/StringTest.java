import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");

        String[] result2 = "1".split(",");
        assertThat(result2).contains("1");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("chatAt 메소드 사용 시, 특정 위치의 문자를 가져온다.")
    void charAt() {
        char result = "abc".charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("chatAt 메소드 사용 시, 특정 위치 값을 벗어날 때 예외가 발생한다.")
    void charAt_whenIndexOutOfBounds() {
        assertThatThrownBy(() -> "abc".charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 3");
    }
}
