import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringTest {

    @Test
    @DisplayName("split 정상동작 테스트")
    void split() {
        String[] testData = "1,2".split(",");
        assertThat(testData).contains("1","2");
    }

    @Test
    @DisplayName("문자열 길이가 1일때 split 정상동작 테스트")
    void split2() {
        String[] testData = "1".split(",");
        assertThat(testData).containsExactly("1");
    }

    @Test
    @DisplayName("substring() 정상동작 테스트")
    void substringTest() {
        String testData = "(1,2)".substring(1,4);
        assertThat(testData).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 정상동작 테스트")
    void charAtTest() {
        String input = "abc";
        assertThat(input.charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt() 사용시 문자길이를 넘으면 예외 발생한다")
    void charAtExceptionTest() {
        String input = "abc";
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            input.charAt(100);
        });
    }
}
