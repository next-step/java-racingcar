import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    @DisplayName("split 함수 - 배열이 잘 생성되었는지 테스트")
    void split_checkElement() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("split 함수 - 배열의 요소와 순서가 올바른지 테스트")
    void split_checkElementsAndOrder() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("substring 함수 - 괄호를 제거하는지 테스트")
    void substring_check() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 함수 - 원하는 위치의 문자를 가져오는지 테스트")
    void charAt_check() {
        char result = "abc".charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt 함수 - StringIndexOutOfBoundsException 테스트")
    void charAt_checkStringIndexOutOfBoundsException() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    "abc".charAt(5);
                }).withMessageMatching("String index out of range: \\d+");
    }

}
