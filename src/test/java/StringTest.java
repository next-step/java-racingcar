import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    void test1_1() {
        String originalString = "1,2";
        String[] splittedString = originalString.split(",");
        assertThat(splittedString).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    void test1_2() {
        String originalString = "1";
        String[] splittedString = originalString.split(",");
        assertThat(splittedString).containsExactly("1");
    }

    // "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현
    private String removeParentheses(String string) {
        return string.substring(1, string.length() - 1);
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 ()을 제거하고 \"1,2\"를 반환하는지 확인")
    void test2() {
        String originalString = "(1,2)";
        assertThat(removeParentheses(originalString)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는지 확인")
    void test3_1() {
        String targetString = "abc";

        assertThat(targetString.charAt(0)).isEqualTo('a');
        assertThat(targetString.charAt(1)).isEqualTo('b');
        assertThat(targetString.charAt(2)).isEqualTo('c');

    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는지 확인")
    void test3_2() {
        String targetString = "abc";

        assertThatThrownBy(() -> targetString.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
