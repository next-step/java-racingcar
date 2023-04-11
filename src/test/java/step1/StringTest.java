package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @DisplayName("'1,2'를 ','로 split 했을 때 1과 2로 잘 분리되는지 확인")
    @Test
    void split1() {
        String[] result1 = "1,2".split(",");
        assertThat(result1).containsExactly("1", "2");
    }

    @DisplayName("'1'을 ','로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    @Test
    void split2() {
        String[] result2 = "1".split(",");
        assertThat(result2).contains("1");
    }

    @DisplayName("(1,2) 값이 주어졌을 때 '()'을 제거하고 '1,2'를 반환")
    @Test
    void split3() {
        String result3 = "(1,2)".substring(1, 4);
        assertThat(result3).isEqualTo("1,2");
    }

    @DisplayName("'abc' 값이 주어졌을 때 charAt()를 활용해 특정 위치의 문자 가져오기")
    @Test
    void chatAt1() {
        char c1 = "abc".charAt(0);
        char c2 = "abc".charAt(1);
        char c3 = "abc".charAt(2);

        assertThat(c1).isEqualTo('a');
        assertThat(c2).isEqualTo('b');
        assertThat(c3).isEqualTo('c');
    }

    @DisplayName("특정 위치 문자를 가져올 때 위치 값 벗어나면 StringIndexOutOfBoundsException 발생 시키기")
    @Test
    void charAt2() {
        assertThatThrownBy(() -> {
            char c4 = "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
