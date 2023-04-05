import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("split() 메서드는 해당 문자열을 인자로 들어온 정규식으로 쪼갠 배열을 리턴한다.")
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("substring() 메서드는 첫 번째 인자 부터 두 번째 인자 전 까지의 인덱스에 해당하는 문자열을 반환한다.")
    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt() 메서드는 인자로 주어진 인덱스에 해당하는 문자를 반환한다.")
    @Test
    void charAt() {
        char target = "abc".charAt(1);
        assertThat(target).isEqualTo('b');
    }

    @DisplayName("charAt() 메서드의 인자가 주어진 문자열 길이 범위를 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    @Test
    void charAt_StringIndexOutOfBoundsException() {
        assertThatThrownBy(() -> "abc".charAt(10))
            .isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: ");
    }
}
