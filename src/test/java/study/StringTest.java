package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("\"1,2\"을 \",\"로 split 했을 때 1과 2로 잘 분리되는지 확인")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 \",\"로 split 했을 때 1만을 포함하는 배열이 반환되는지")
    void splitOneParts() {
        String[] result = "1".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1");
    }

    @ParameterizedTest
    @DisplayName("\"(1,2)\"값이 주어졌을 때 String의 substring() 메소드를 활용해 \"()\"을 제거하고 \"1,2\" 반환")
    @ValueSource(strings = {"(1,2)"})
    void substring(String str) {
        String result = str.substring(str.indexOf("(") + 1, str.indexOf(")"));
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는지 확인")
    void chatAt() {
        String str = "abc";
        assertThat(str.charAt(1)).isEqualTo('b');
    }

    @ParameterizedTest
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생")
    @ValueSource(ints = {-1, 3})
    void charAtWithException(int index) {
        String str = "abc";
        assertThatThrownBy(() -> str.charAt(index)).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageMatching("String index out of range: [-]?\\d+");
    }
}
