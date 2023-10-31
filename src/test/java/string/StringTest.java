package string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @DisplayName("split 메서드를 사용해 문자열을 나눈다.")
    @Test
    void splitByCommas() {
        String str = "1,2";
        String[] results = str.split(",");

        assertThat(results).hasSize(2)
                .containsExactly("1", "2");
    }

    @DisplayName("split 메서드는 기준 문자가 없어도 정상적으로 동작한다.")
    @Test
    void splitByCommasWithoutRegex() {
        String str = "1";
        String[] results = str.split(",");

        assertThat(results).hasSize(1)
                .containsExactly("1");
    }

    @DisplayName("substring 메서드는 index를 기준으로 문자열을 분리한다.")
    @Test
    void substringByIndex() {
        String str = "(1,2)";
        String result = str.substring(1,4);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt 메서드가 범위를 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    @Test
    void getCharByCharAt() {
        String str = "abc";

        assertThat(str.charAt(0)).isEqualTo("a");
        assertThat(str.charAt(1)).isEqualTo("b");
        assertThat(str.charAt(2)).isEqualTo("c");

        assertThatThrownBy(() -> str.charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class);

    }
}
