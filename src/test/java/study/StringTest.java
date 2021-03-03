package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("요구사항 1 : \"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지, \"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인하는 테스트")
    void split() {
        String[] result = "1,2".split(",");
        String[] result2 = "1".split(",");
        assertThat(result).containsExactly("1", "2");
        assertThat(result2).contains("1");
    }

    @Test
    @DisplayName("요구사항 2 : \"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하는 테스트")
    void substring() {
        String numbers = "(1,2)";
        assertThat(numbers.substring(1, numbers.length() - 1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3 : \"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오고, 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 테스트")
    void getChar() {
        String alphabet = "abc";
        assertThat(alphabet.charAt(0)).isEqualTo('a');
        assertThatThrownBy(() -> alphabet.charAt(-1)).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("index out of range: -1");
    }
}
