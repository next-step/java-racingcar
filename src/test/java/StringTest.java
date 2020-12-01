import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("\"1,2\"를 ,로 split 했을 때 1과 2로 잘 분리됨")
    void split_test() {
        String testString =  "1,2";
        String[] results = testString.split(",");
        assertThat(results).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1 만 포함하는 배열 반환")
    void split_one_string_test() {
        String testString = "1";
        String[] results = testString.split(",");
        assertThat(results).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 substring 메소드로 ()을 제거하고 \"1,2\"를 반환")
    void substring_test() {
        String testString = "(1,2)";
        String result = testString.substring(1, testString.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\" 문자열에서 두번째 문자(b) 가져오기")
    void charAt_test() {
        String testString = "abc";
        char result = testString.charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("\"abc\" 문자열에서 5번째 문자열 가져오면 StringIndexOutOfBoundsException 발생")
    void charAt_StringIndexOutOfBoundsException_test() {
        String testString = "abc";
        assertThatThrownBy(() -> {
            testString.charAt(4); })
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}
