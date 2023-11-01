package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("문자열을 (,)로 split 했을 때 특정 값이 배열 내에 존재하는 지 확인하는 테스트")
    void split() {
        String[] results = "1,2".split(",");
        assertThat(results).contains("1");
        assertThat(results).containsExactly("1", "2");
    }

    @Test
    @DisplayName("길이가 1인 문자열을 split했을 때 1만 포함하는 배열이 반환되는지 확인")
    void split2() {
        String[] results = "1".split(",");
        assertThat(results).hasSize(1);
        assertThat(results).contains("1");
        assertThat(results).containsExactly("1");
    }

    @Test
    @DisplayName("주어진 문자열 내에 문자를 charAt으로 찾았을 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 예외가 발생하는지 확인하는 테스트")
    void substring() {
        String data = "abc";

        assertThatThrownBy(() -> {
            char character = data.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                char character = data.charAt(3);
        }).withMessageMatching("String index out of range: 3");

    }
}
