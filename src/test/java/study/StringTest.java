package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("문자열 ',' 기준으로 자르기 테스트")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("() 자르고 반환되는지 테스트")
    void substring() {
        String data = "(1,2)";
        String result = data.substring(1, data.length()-1);
        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("특정 위치 문자열 가져오기 테스트")
    void charAt() {
        String data = "abc";
        assertThat(data.charAt(1)).isEqualTo('b');
    }

    @Test
    @DisplayName("범위 벗어난 문자 요청시 예외처리")
    void indexOutBoundsException() {
        String data = "abc";
        assertThatThrownBy(() -> data.charAt(-1)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
