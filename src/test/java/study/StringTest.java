package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("1,2를 ,로 split 했을때 1과 2로 분리")
    void splitOneAndTwo() {
        String[] result = "1,2".split(",");

        assertThat(result)
                .containsExactly("1", "2");
    }

    @Test
    @DisplayName("1을 , 로 split 했을때 1만이 포함되는 배열 반환")
    void splitOne() {
        String[] result = "1".split(",");

        assertThat(result)
                .contains("1")
                .hasSize(1);
    }

    @Test
    @DisplayName("(1,2) 값이 주어졌을때 substring() 을 사용해 () 를 제거하고 1,2 반환")
    void substring() {
        String result = "(1,2)".substring(1, 4);

        assertThat(result)
                .isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc 값에 chatAt() 을 사용해 특정위치 문자 반환")
    void charAt() {
        String abc = "abc";
        char a = abc.charAt(0);
        char b = abc.charAt(1);
        char c = abc.charAt(2);

        assertThat(a)
                .isEqualTo('a');
        assertThat(b)
                .isEqualTo('b');
        assertThat(c)
                .isEqualTo('c');
    }

    @Test
    @DisplayName("chatAt() 을 통해 요청한 인덱스가 타겟의 위치값을 벗어나면 StringIndexOutOfBoundsException 발생")
    void StringIndexOutOfBoundsExceptionIfTargetMaxIndexLessThenIndex() {
        String target = "TEST";

        assertThatThrownBy(() -> {
            target.charAt(target.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}
