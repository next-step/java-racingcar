package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("split() 메소드 사용, 문자열 자르기 테스트")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).as("실패, 일부 문자열을 찾을 수 없습니다").containsExactly("1","2");
        assertThat(result).as("실패, 문자열을 찾을 수 없습니다").contains("1");
    }

    @Test
    @DisplayName("substring() 메소드 사용, 문자열 인덱스를 사용하여 자르기 테스트")
    void substring() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).as("실패, 서로 다른 문자열 입니다.").isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드 사용, 인덱스로 문자를 리턴하는 테스트")
    void charAt() {
        String result = "abc";
        assertThat(result.charAt(0)).as("실패, 서로 문자가 일치하지 않습니다").isEqualTo('a');
        assertThat(result.charAt(1)).as("실패, 서로 문자가 일치하지 않습니다").isEqualTo('b');
        assertThat(result.charAt(2)).as("실패, 서로 문자가 일치하지 않습니다").isEqualTo('c');
    }

    @Test
    @DisplayName("charAt() 메소드 사용,위치 값을 벗어나 발생한 StringIndexOutOfBoundsException 테스트")
    void assertThrowsException() {
        String result = "abc";
        assertThatThrownBy(() -> {
            result.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
          .hasMessageContaining("String index out of range: ");
    }

}
