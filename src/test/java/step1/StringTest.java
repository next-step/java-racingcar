package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {
    @Test
    @DisplayName("'1,2'을 ','로 split 했을 때 1과 2로 잘 분리되는지 확인")
    void splitTwoNum() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("'1'을 ','로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    void splitOneNum() {
        String[] result =  "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("'(1,2)' 값이 주어졌을 때 substring() 메소드를 활용해 ()을 제거하고 '1,2'를 반환하는지 확인")
    void removeParenthesesUsingSubString() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("'abc' 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는지 확인")
    void getCharacterUsingCharAt() {
        char result = "abc".charAt(0);
        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는지 확인")
    void stringIndexOutOfBoundsExceptionTest() {
        assertThatThrownBy(() -> {
            "abc".charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
