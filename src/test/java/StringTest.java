import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {
    @DisplayName("1,2를 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 테스트")
    @Test
    void test001() {
        String[] testStringArray = "1,2".split(",");

        assertThat(testStringArray).contains("1", "2");
    }

    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인하는 테스트")
    @Test
    void test002() {
        String[] testStringArray = "1".split(",");

        assertThat(testStringArray).containsExactly("1");
    }

    @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2를 반환하는지 테스트")
    @Test
    void test003() {
        String testString = "(1,2)".substring(1,4);

        assertThat(testString).isEqualTo("1,2");
    }

    @DisplayName("abc 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 테스트 - 성공")
    @Test
    void test004() {
        assertThat("abc".charAt(0)).isEqualTo('a');
        assertThat("abc".charAt(1)).isEqualTo('b');
        assertThat("abc".charAt(2)).isEqualTo('c');
    }

    @DisplayName("abc 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 테스트 - 실패")
    @Test
    void test005() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> "abc".charAt(5));
    }
}
