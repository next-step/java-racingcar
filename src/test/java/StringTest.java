import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringTest {

    @Test
    @DisplayName("문자열 1,2를 ,를 기준으로 split 헸을 때 1과 2로 잘 분리되는지 테스트한다")
    void splitTest() {
        String testString = "1,2";

        String[] resultString = testString.split(",");

        assertThat(resultString).contains("1");
        assertThat(resultString).contains("2");
        assertThat(resultString).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열 (1,2)를 subString 하여 1,2를 반환한다.")
    void subStringTest() {
        String testString = "(1,2)";

        String resultString = testString.substring(1, 4);

        assertThat(resultString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열 abc를 charAt을 통해 특정 위치의 문자를 가져오는 테스트를 구현한다.")
    void charAtTest() {
        String testString = "abc";

        char result0 = testString.charAt(0);
        char result1 = testString.charAt(1);
        char result2 = testString.charAt(2);

        assertThat(result0).isEqualTo('a');
        assertThat(result1).isEqualTo('b');
        assertThat(result2).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt의 범위가 문자열의 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    void charAtExceptionTest() {
        String testString = "abc";
        int overLength = testString.length();

        Assertions.assertThatThrownBy(() -> testString.charAt(overLength))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + overLength);
    }
}
