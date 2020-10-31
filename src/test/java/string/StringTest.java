package string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    @DisplayName("문자열 분리로 반환되는 배열 검증")
    public void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }
    
    @Test
    @DisplayName("문자열 추출로 반환되는 값 검증")
    public void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }
    
    @Test
    @DisplayName("문자열 중 특정 위치의 문자 검증")
    public void chatAt() {
        assertThat("abc".charAt(0)).isEqualTo('a');
        assertThat("abc".charAt(1)).isEqualTo('b');
        assertThat("abc".charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("문자열을 벗어난 위치 값으로 문자를 가져오는 경우")
    public void charAt_invalid_index() {
        int invalid_index = 3;
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(invalid_index));
    }
}
