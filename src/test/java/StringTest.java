import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class StringTest {

    @Test
    @DisplayName("split(): 구분자로 문자열을 분리하여 반환")
    void split_1() {
        String data = "1,2";
        String[] result = data.split(",");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("split(): 구분자가 없으면 문자열 그래도 반환")
    void split_2() {
        String data = "1";
        String[] result = data.split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("substring(): 괄호를 제거하고 반환")
    void substring() {
        String data = "(1,2)";
        String result = data.substring(1,data.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt(): 주어진 인덱스의 문자를 반환")
    void charAt_1() {
        String data = "abc";
        Character result = data.charAt(0);
        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt(): 주어진 인덱스가 범위를 벗어나면 IndexOutOfBoundsException 발생")
    void charAt_2() {
        String data = "abc";
        assertThatThrownBy(() -> {
            data.charAt(data.length());
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + data.length());
    }
}

