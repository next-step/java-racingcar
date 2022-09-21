import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @DisplayName("문자열 1,2 을 ,로 split 했을 때 1과 2로 분리된다")
    @Test
    void split_when_1_2() {
        // given
        String testStrings = "1,2";
        // when
        List<String> splitStrings = Arrays.asList(testStrings.split(","));
        // then
        assertThat(splitStrings).containsOnly("1", "2");
    }

    @DisplayName("문자열 1 을 ,로 split 했을 때 1 만으로 분리된다")
    @Test
    void split_when_1() {
        // given
        String testStrings = "1";
        // when
        List<String> splitStrings = Arrays.asList(testStrings.split(","));
        // then
        assertThat(splitStrings).containsOnly("1");
    }

    @DisplayName("(1,2) 에서 괄호를 제거하고 1,2 를 반환한다")
    @Test
    void remove_parentheses() {
        // given
        String testString = "(1,2)";
        // when
        String actual = testString.substring(1, testString.length() - 1);
        // then
        assertThat(actual).isEqualTo("1,2");
    }

    @DisplayName("abc 문자열에서 찾으려는 위치가 위치값을 벗어나면 StringIndexOutOfBoundsException 예외를 발생시킨다")
    @Test
    void charAt_when_occured_StringIndexOutOfBoundsException() {
        // given
        String testString = "abc";
        int index = 3;
        // when then    
        assertThatThrownBy(() -> {
            char charic = testString.charAt(index);
        }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageMatching("String index out of range: " + index);
    }
}
