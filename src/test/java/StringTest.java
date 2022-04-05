import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class StringTest {

    @Test
    @DisplayName("1,2를 ,로 split 할 경우 1과 2로 잘 분리하는지에 대한 테스트")
    void splitTest() {
        String[] str = "1,2".split(",");
        assertThat(str).containsExactly("1","2");
    }

    @Test
    @DisplayName("1을 ,로 split 할 경우 1만 포함하는 배열로 반환되는지에 대한 테스트")
    void splitTest2() {
        String[] str = "1".split(",");
        int strLength = str.length;
        assertThat(strLength).isEqualTo(1);
    }

    @Test
    @DisplayName("substring으로 메소드 활용하여 ( ) 제거하고 1,2 반환하는지에 대한 테스트")
    void substringTest() {
        String str = "(1,2)".substring(1, 4);
        assertThat(str).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메소드를 활용해 특정 위치의 문자를 가져오는 테스트")
    void charAtTest() {
        char chr = "abc".charAt(1);
        assertThat(chr).isEqualTo('b');

    }

    @Test
    @DisplayName("charAt 메소드를 활용하여 특정문자를 가져올 때 위치 값을 벗어났을 경우에 대한 테스트")
    void stringIndexOutOfBoundsExceptionTest() {
        assertThatThrownBy(()-> {
            "abc".charAt(6);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 6");
    }
}
