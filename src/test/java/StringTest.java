import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("요구사항1 - split() 메서드를 활용해 , 기준으로 분리한 배열을 반환")
    void stringSplitTest() {
        String[] value = "1,2".split(",");
        assertThat(value).containsExactly("1", "2");

        String[] value2 = "1".split(",");
        assertThat(value2).contains("1");
    }

    @Test
    @DisplayName("요구사항2 - substring() 메서드를 활용해 괄호를 제거하고 \"1,2\"를 반환")
    void substringTest() {
        String value = "(1,2)";
        String result = value.substring(1, value.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3 - String의 charAt 메서드를 호출하면 해당 위치의 문자를 반환한다.")
    void stringCharAtTest() {
        String value = "abc";
        char result = value.charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("요구사항3 - String의 charAt 메서드를 호출할 때 위치값을 벗어나면 에러를 던진다.")
    void stringCharAtFailTest() {
        String value = "abc";
        int index = value.length() + 1;
        assertThatThrownBy(() -> value.charAt(index))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("out of bounds for length");
    }
}
