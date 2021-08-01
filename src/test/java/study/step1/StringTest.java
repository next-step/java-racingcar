package study.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class StringTest {

    // contains - 중복여부, 순서에 관계 없이 값만 일치하면 테스트가 성공
    // containsExactly - 순서를 포함해서 정확히 일치

    @Test
    @DisplayName("split 테스트 : 숫자 2개")
    void split1() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("split 테스트 : 숫자 1개")
    void split2() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("substring 테스트 : 가로 삭제")
    void substring1() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);
        assertEquals(result, "1,2");
    }

    @Test
    @DisplayName("charAt 테스트 : 성공 케이스")
    void charAt1() {
        String abc = "abc";

        assertEquals('a', abc.charAt(0));
        assertEquals('b', abc.charAt(1));
        assertEquals('c', abc.charAt(2));
    }

    @Test
    @DisplayName("charAt 테스트 : index exception")
    void charAt2() {
        String abc = "abc";

        assertThatThrownBy(() -> abc.charAt(4))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }

}
