package study.step1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("'1,2'를 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1,를 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    void onlyOne() {
        String[] result = "1,".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2)값이 주어졌을 때 ()를 제거하고 1,2가 반환되는지 확인")
    void subStringTest(){
        String s = "(1,2)";
        String[] result = s.substring(1,4).split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 성공적으로 반환한다.")
    void indexTest() {
        String value = "abc";
        char result = value.charAt(1);

        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치값을 벗어나면 예외가 발생한다.")
    void indexExceptionTest() {
        String value = "abc";

        assertThatThrownBy(() -> {
            char result = value.charAt(4);
        })
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
